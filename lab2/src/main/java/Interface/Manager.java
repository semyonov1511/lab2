
package Interface;

import java.io.IOException;

public class Manager {
    ExcelProvider provider = new ExcelProvider();
    
    public void Import() throws IOException{
        Repository.getInstance().setMas(provider.readExcel());
    }
    
    public void Export() throws IOException{
        provider.writeExcel(Repository.getInstance().getMas());
    }
    
    public void Calculate(){
        Repository.getInstance().setParameters();
    }
}
