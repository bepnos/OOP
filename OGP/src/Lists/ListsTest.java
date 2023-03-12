/**
 * Definieer een klassenhiërarchie om onwijzigbare lijsten van int-waarden voor te stellen. Er zijn twee soorten lijsten: de lege lijst, 
 * en de niet-lege lijsten. Een niet-lege lijst wordt volledig gedefinieerd door haar kop (het eerste element) en haar staart (de lijst met de rest van de elementen).

Laat de klant toe een Lijst-object op te vragen dat een lege lijst voorstelt, of een object dat een lijst met een gegeven kop en gegeven staart voorstelt,
 de lengte van een lijst op te vragen, en de kop en de staart van een niet-lege lijst op te vragen. Zorg dat twee lijsten door bv. 
 JUnit als gelijk beschouwd worden als ze dezelfde sequentie van int-waarden voorstellen.
  Zorg ook dat je de volgende tekstuele voorstelling krijgt: bv. [1, 2, 3] voor de lijst 1, 2, 3, als je een Lijst-object bv. 
  afdrukt met System.out.println of optelt bij een String.
 */


package Lists;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class List{
	List(int[] input){
		new ListNonEmpty(input);
	}
	List() {
		int a = 2;
		new ListEmpty(a);
	}
}

class ListNonEmpty extends List{
	int head;
	List tail; 
	int getHead() {
		return this.head;
	}
	ListNonEmpty(int[] elements){
		this.head = elements[0];
		if (elements.length == 1)
			this.tail = new List();
		else {
			int[] arr = Arrays.copyOfRange(elements, 1, elements.length);
			this.tail = new ListNonEmpty(arr);
		}
	}
	
}



class ListEmpty extends List{
	int test; 
	ListEmpty(int a){
		this.test = a;
	}
	
	public int getGetal(){
		return this.test;
	}
}




class ListsTest {
	@Test
	void test() {
		List list2 = new List();
		if (list2 instanceof ListEmpty lst) {
			assertEquals(7, lst.getGetal());
		}
	}

}
