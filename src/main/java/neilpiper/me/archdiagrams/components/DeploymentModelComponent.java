package neilpiper.me.archdiagrams.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/** Component class to establish DeploymentNodes, Container instances
 * to populate Deployment Views
 * 
 * Depends on aspects of the core model such as Containers, Software systems
 * 
 * @author neilpiper
 *
 */
@Component
public class DeploymentModelComponent {

  @Autowired
  ArchModelComponent modelComponent;
  
  
  
}
