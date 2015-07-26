
package in.weq.oneness.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@ManagedBean(name = "dashboard")
@ViewScoped
public class DashboardManagedBean {
    
    
    @PostConstruct
    public void init() {
  
    }
     
    public void onTabChange(TabChangeEvent event) {
        System.out.println("advndvu");
    }
         
    public void onTabClose(TabCloseEvent event) {
        System.out.println("advndvucwrhyt");
    }
}