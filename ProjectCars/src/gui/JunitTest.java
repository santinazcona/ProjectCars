package gui;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTest {

	//Test que prueba que la extensiones de coche son la que tienen que ser
	@Test
	public void test(){
		assertTrue(prueba());
	}
	
	public boolean prueba(){
		JCarreteraP2 a = new JCarreteraP2();
		if(a.c1.getAlturaCoche()==70){
			if(a.c1.getAnchoCoche()==40){
				return true;
			}
		}
		return false;	
	}
}
