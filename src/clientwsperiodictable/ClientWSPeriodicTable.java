
package clientwsperiodictable;
import java.io.File;
import java.util.Scanner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ClientWSPeriodicTable {

    
    public static void main(String[] args) throws Exception {
        while(true){
            Serializer serializer = new Persister();
            String source = getElementSymbol("gold");

            Element elemento = serializer.read(Element.class, source);
            System.out.println("symbol: " + elemento.getSymbol());
        Scanner input = new Scanner(System.in);
        System.out.print("Elija un elemento de la tabla periódica: ");
        String element = input.next();
        
        System.out.println("Seleccione el método a usar\n 1) Obtener el el número atómico"
                + "\n 2) Obtener el peso atómico\n 3) Obtener átomos\n 4) Obtener su símbolo" );
        
        int method = input.nextInt();
        switch(method) {
            case 1 : System.out.println(getAtomicNumber(element));
            break;
            case 2 : System.out.println(getAtomicWeight(element));
            break;
            case 3 : System.out.println(getAtoms());
            break;
            case 4 : System.out.println(getElementSymbol(element));
            break;
               
        }
       
        }
    }

    private static String getAtomicNumber(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicNumber(elementName);
    }

    private static String getElementSymbol(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getElementSymbol(elementName);
    }

    private static String getAtomicWeight(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicWeight(elementName);
    }

    private static String getAtoms() {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtoms();
    }

   
    
}
