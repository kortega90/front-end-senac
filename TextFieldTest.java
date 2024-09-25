// Fig. 12.10: TextFieldTest.java
// Testing TextFieldFrame.
import javax.swing.JFrame;

/**
 * @param public classe do tipo publico
 * @param TextFieldTest  nome da classe a ser declarada 
 */
public class TextFieldTest
{
      /**
    * @param main esta sendi declarado o metodo main que vai executar o app
    */
   public static void main(String[] args)
   { 
      // chama o labelFrame e declara a funcao setDefaultCloseOperation passando como argumento.
      TextFieldFrame textFieldFrame = new TextFieldFrame(); 
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // chama o labelFrame e declara a funcao setSize.
      textFieldFrame.setSize(350, 100); 
       // habilita a visibilidade do modal
      textFieldFrame.setVisible(true); 
   } 
} // end class TextFieldTest

