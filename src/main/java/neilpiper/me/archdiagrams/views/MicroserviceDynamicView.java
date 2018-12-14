package neilpiper.me.archdiagrams.views;

import org.springframework.stereotype.Component;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.model.Tags;
import com.structurizr.view.ContainerView;
import com.structurizr.view.Routing;
import com.structurizr.view.Shape;
import com.structurizr.view.Styles;
import com.structurizr.view.View;
import com.structurizr.view.ViewSet;
import neilpiper.me.archdiagrams.components.ArchModelComponent;

@Component
public class MicroserviceDynamicView extends AbstractPlantUMLDiagram implements PlantUMLDiagram {

  @Override
  public <T extends View> View getView() {
    // TODO Auto-generated method stub
    
    ViewSet views = this.archModel.workspace.getViews();
    
    SoftwareSystem system = this.archModel.model.getSoftwareSystemWithName("Customer Information System");

    ContainerView containerView = views.createContainerView(system, "Containers", null);
    containerView.addAllElements();
    
    
    Styles styles = views.getConfiguration().getStyles();
    styles.addElementStyle(Tags.ELEMENT).color("#000000");
    styles.addElementStyle(Tags.PERSON).background("#ffbf00").shape(Shape.Person);
    styles.addElementStyle(Tags.CONTAINER).background("#facc2E");
    styles.addElementStyle(ArchModelComponent.MESSAGE_BUS_TAG).width(1600).shape(Shape.Pipe);
    styles.addElementStyle(ArchModelComponent.MICROSERVICE_TAG).shape(Shape.Hexagon);
    styles.addElementStyle(ArchModelComponent.DATASTORE_TAG).background("#f5da81").shape(Shape.Cylinder);
    styles.addRelationshipStyle(Tags.RELATIONSHIP).routing(Routing.Orthogonal);

    styles.addRelationshipStyle(Tags.ASYNCHRONOUS).dashed(true);
    styles.addRelationshipStyle(Tags.SYNCHRONOUS).dashed(false);
    
    return containerView;
  }

  @Override
  public void setUMLSkinParams() {
    // TODO Auto-generated method stub
    
  }

}
