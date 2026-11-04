package co.gov.dian.muisca;

//import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleTest {

    private Example example;
    //Este mét0d0 se ejecuta una vez por cada Test
    @BeforeEach
    public void init(){
        example=new Example();
    }

    @Test
    public void testSumar(){
        //Given (Los insumos que necesitamos)
        int numberA=3;
        int numberB=3;
        //When (Se ejecuta el mét0d0 que estamos probando)
        int result=example.sumar(numberA,numberB);

        //Then (Aquí evaluamos los resultados)
        assertEquals(6,result);
        assertNotNull(result);
        assertInstanceOf(Integer.class,result);
    }

    @Test
    public void testCheckPositivo(){
        //Given
        int argumentoPositivo=3;
        //when
        boolean esPositivo=example.checkPositivo(argumentoPositivo);
        //Then
        assertTrue(esPositivo);
    }

    @Test
    public void testCheckPositivoError(){
        //Given
        int argumentoNegativo=-3;
        //When
        assertThrows(IllegalArgumentException.class,()->{
            example.checkPositivo(argumentoNegativo);
        });

        //NOTA: En excepciones no va el Then, porque en el When nosotros ya evaluamos
        //con el assertThrows
    }

    @Test
    public void testContarLetrasA(){
        //Given
        String cadena="un programador nace";
        //When
        int numeroLetras=example.contarLetrasA(cadena);
        //Then
        assertEquals(3,numeroLetras);
    }

    @Test
    public void testContieneElemento(){
        //Given
        /*
        List<String> desarrolladores=new ArrayList<>();
        desarrolladores.add("Jorge René");
        desarrolladores.add("Diego Germán");
        desarrolladores.add("Juan Camilo");
        desarrolladores.add("Javier");*/

        List<String> desarrolladores=List.of("Jorge René","Diego Germán","Juan Camilo","Javier");
        String desarrollador="Juan Camilo";
        //When
        boolean seEncuentra=this.example.contieneElemento(desarrolladores, desarrollador);
        //Then
        assertTrue(seEncuentra);
    }

    @Test
    public void testRevertirCadena(){
        //Given
        String cadena="roma ni se conoce sin oro ni se conoce sin amor";
        //When
        String cadenaInvertida= this.example.revertirCadena(cadena);
        //Then
        assertEquals("roma nis econoc es in oro nis econoc es in amor",
                cadenaInvertida);
    }

    @Test
    public void testFactorial(){
        //Given
        int number=10;
        //When
        long result=this.example.factorial(number);
        //Then
        assertEquals(3628800,result);
    }
    @Test
    public void testFactorialError(){
        //Given
        int number=-2;
        //When
        assertThrows(IllegalArgumentException.class,()->{
            this.example.factorial(number);
        });
    }

    @Test
    public void testEsPrimo(){
        //Given
        int number1=77;
        int number2=79;
        //When
        boolean result1=example.esPrimo(number1);
        boolean result2=example.esPrimo(number2);
        //Then
        assertTrue(result2);
        assertFalse(result1);
    }

    @Test
    public void testEsPrimoNegativo(){
        //Given
        int number=-7;
        //When
        boolean result=example.esPrimo(number);
        //Then
        assertFalse(result);
    }

    @Test
    public void testMensajeConRetraso() throws InterruptedException{
        //Given

        //When
        String mensaje=this.example.mensajeConRetraso();
        //Then
        assertEquals("Listo después de retraso",mensaje);
    }
    //NOTA: No se testea el tiempo

    @Test
    public void testConvertirAString(){
        //Given
        List<Integer> numbers=List.of(0,1,2,3,4,5,6,7,8,9,10);
        //When
        List<String> numbersString=this.example.convertirAString(numbers);
        //Then
        assertEquals(List.of("0","1","2","3","4","5","6","7","8","9","10"),numbersString);
    }

    @Test
    public void testCalcularMedia(){
        //Given
        List<Integer> notasEstudiante=List.of(5,7,9,4,7,8,9);

        //When
        double notaFinal=this.example.calcularMedia(notasEstudiante);
        //Then
        assertEquals(7.0,notaFinal);
    }
    @Test
    public void testCalcularMediaListaVacia(){
        //Given
        List<Integer> listaVacia=List.of();
        //When-Then
        assertThrows(IllegalArgumentException.class,()->{
            this.example.calcularMedia(listaVacia);
        });
    }

    @Test
    public void testCalcularMediaNull(){
        //Given
        List<Integer> listaNull=null;
        //When-Then
        assertThrows(IllegalArgumentException.class,()->{
            this.example.calcularMedia(listaNull);
        });
    }

    @Test
    public void testConvertirListaAString(){
        //Given
        List<String> cadenaList=List.of("Pedro","Pablo","Pérez","Pereira","pobre","pintor","portugues");
        //When
        String cadena=this.example.convertirListaAString(cadenaList);
        //Then
        assertEquals("Pedro,Pablo,Pérez,Pereira,pobre,pintor,portugues".toUpperCase(),cadena);
    }
}
