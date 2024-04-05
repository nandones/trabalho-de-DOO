
package Controller;

/*ESTA CLASSE TEM COMO FUNÇÃO PERMITIR LIMITAR A SOMENTE 3 DIGITOS AO CADASTRAR O NOME DO TIME
NO JTABLE DO PAIMEL 'CADASTRAR TIMES"*/
    
    
    
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class FormatacaoJTABLE extends DefaultCellEditor {
    public FormatacaoJTABLE() {
        super(new JTextField());
        JTextField textField = (JTextField) getComponent();
        textField.setDocument(new LimitedDocument(3)); // Definindo o limite de 3 caracteres
    }
    }

class LimitedDocument extends PlainDocument {
    private int limit;

    public LimitedDocument(int limit) {
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
    
    
    
    
    
    

