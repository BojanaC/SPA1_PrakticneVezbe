/**
 * Napraviti klasu koja predstavlja jednostruko povezanu listu tipa St-
 * ring. U klasu dodati metod koji:
 * a) prebrojava koliko u listi ima elemenata koji počinju velikim slo-
 *    vom.
 * b) Računa prosečnu vrednost dužine Stringova u listi.
 * c) Iz liste briše elemente koji su veći od prethodnog elementa (duž-
 *    ina Stringa trenutnog elementa je veća od dužine Stringa njegovog
 *    prethodnika), tako da na kraju imamo listu sa nerastućim element-
 *    ima.
 * 
 * Napisati program koji učitava n String-ova i smešta ih u instancu n-
 * apravljene klase. Nakon toga pozvati dodatne metode i štampati stan-
 * je pre i posle poziva po potrebi.
 */

class N03Z03P04 {
	
	public static void main(String[] args) {
		
		Lista lista = new Lista();
		
		int n = Svetovid.in.readInt("Broj: ");
		
		for (int i = 0; i < n; i++) {
			
			String s = Svetovid.in.readLine("Element #" + i + ": ");
			lista.dodajNaPocetak(s);
		}
		
		System.out.println(lista);
		
		lista.prebrojVelike();
		
		lista.prosecnaDuzina();
		
		lista.obrisiDuze();
		System.out.println(lista);
	}
}

class Lista {
	
	class Element {
		
		String info;
		Element veza;
		
		
		public Element(String info) {
			this.info = info;
			this.veza = null;
		}
		
		
		public String toString() {
			return info;
		}
	}
	
	
	Element prvi;
	
	
	public void dodajNaPocetak(String info) {
		
		Element novi = new Element(info);
		
		novi.veza = prvi;
		prvi = novi;
	}
	
	
	public int prebrojVelike() {
		
		if (prvi == null)
			return -1;
			
		Element tek = prvi;
		int count = 0;
		
		while (tek != null) {
			
			if ('A' <= tek.info.charAt(0) && tek.info.charAt(0) <= 'Z')
				count++;
				
			tek = tek.veza;
		}
		
		System.out.println("Elemenata koji pocinju velikim slovom: " + count);
		return count;
	}
	
	
	public double prosecnaDuzina() {
		
		if (prvi == null)
			return -1.0;
			
		Element tek = prvi;
		
		double sum = 0.0;
		int count = 0;
		
		while (tek != null) {
			
			sum += tek.info.length();
			count++;
			
			tek = tek.veza;
		}
		
		System.out.println("Prosecna duzina elemenata: " + (sum / count));
		return sum / count;
	}
	
	
	public void obrisiDuze() {
		
		if (prvi == null)
			return;
			
		while (prvi.veza != null && prvi.veza.info.length() > prvi.info.length())
			prvi.veza = prvi.veza.veza;
			
		Element pret = prvi;
		
		while (pret.veza != null) {
			
			if (pret.veza.info.length() > pret.info.length())
				pret.veza = pret.veza.veza;
				
			pret = pret.veza;
		}
	}
	
	
	public String toString() {
		
		String output = "[ Lista : ";
		
		Element tek = prvi;
		
		while (tek != null) {
			
			output += tek + " ";
			tek = tek.veza;
		}
		
		return output + "]";
	}
}
