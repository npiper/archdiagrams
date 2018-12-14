package neilpiper.me.archdiagrams.components;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.structurizr.view.ViewSet;
import neilpiper.me.archdiagrams.views.PlantUMLDiagram;

@Service
public class ArchViewsComponent {

  @Autowired
  ArchModelComponent model;
  
  // https://dzone.com/articles/load-all-implementors
  // Autowire all diagrams based on Interface type
  List<PlantUMLDiagram> diagrams;

  @Autowired
  public ArchViewsComponent(List<PlantUMLDiagram> diagrams) {
      this.diagrams = diagrams;
  }

  public void showDiagrams() {
      diagrams.forEach(System.out::println);
  }
  
  
  public ViewSet views;
  
  @PostConstruct
  public void buildViews()
  {
    
    views = model.workspace.getViews();

  }
  
  public String getDiagramByID(String id)
  {
    return diagrams.get(0).getPlantUML();
    
  }
  
}
