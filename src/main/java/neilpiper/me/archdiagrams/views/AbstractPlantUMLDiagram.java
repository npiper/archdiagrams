package neilpiper.me.archdiagrams.views;

import java.io.StringWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.structurizr.io.plantuml.PlantUMLWriter;
import com.structurizr.view.View;
import neilpiper.me.archdiagrams.components.ArchModelComponent;

public abstract class AbstractPlantUMLDiagram implements PlantUMLDiagram {
  
  @Autowired
  protected ArchModelComponent sapiModel;
  protected PlantUMLWriter plantUMLWriter = new PlantUMLWriter();

  // Sub-classes implement method to create the view
  public abstract <T extends View> View getView();
  
  /** Hook method to allow setting Skin parameters when generating UML
   * Use the protected plantUMLWriter attribute.
   * 
   * plantUMLWriter.addSkinParam("rectangleFontColor", "#ffffff");
   */
  public abstract void setUMLSkinParams();
  
  public String getPlantUML()
  {
    StringWriter stringWriter = new StringWriter();
    plantUMLWriter.clearSkinParams();
    
    // call abstract method
    setUMLSkinParams();
    
    // Call abstract method
    plantUMLWriter.write(getView(), stringWriter);
    
    return stringWriter.toString();
  }

}
