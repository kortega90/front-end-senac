
import javax.swing.JFrame;
/**
 * @param public classe do tipo publico
 * @param LabelTest  nome da classe a ser declarada 
 */
public class LabelTest 
{
   /**
    * @param main esta sendi declarado o metodo main que vai executar o app
    */
   public static void main(String[] args)
   { 
      // LabelFrame é o tipo do objeto
      // new LabelFrame() esta criando uma nova instacia do obejeto na memoria
      LabelFrame labelFrame = new LabelFrame(); 
      // chama o labelFrame e declara a funcao setDefaultCloseOperation passando como argumento.
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // chama o labelFrame e declara a funcao setSize.
      labelFrame.setSize(260, 180); 
      labelFrame.setVisible(true); 
   } 
} 
