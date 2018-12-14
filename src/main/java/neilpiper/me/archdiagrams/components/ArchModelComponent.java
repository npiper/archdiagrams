package neilpiper.me.archdiagrams.components;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.structurizr.Workspace;
import com.structurizr.model.Container;
import com.structurizr.model.InteractionStyle;
import com.structurizr.model.Model;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;


/**
 * The SAPI Model Component represents the establishment of the model of C4 Software Architecture
 * elements and relationships.
 * 
 * It should operate up to the 'Container' level with interrogation of codebases preferred for
 * building up the Component level views of an Architecture.
 * 
 * Views and Deployment Models are not represented in this space
 * 
 * @author neilpiper
 *
 */
@Component
public class ArchModelComponent {


  public static final String MICROSERVICE_TAG = "Microservice";
  public static final String MESSAGE_BUS_TAG = "Message Bus";
  public static final String DATASTORE_TAG = "Database";

  
  public Workspace workspace;
  public Model model;

  @PostConstruct
  public void buildModel() {

    workspace = new Workspace("Microservices example",
        "An example of a microservices architecture, which includes asynchronous and parallel behaviour.");
    model = workspace.getModel();
    
    SoftwareSystem mySoftwareSystem =
        model.addSoftwareSystem("Customer Information System", "Stores information ");
    Person customer = model.addPerson("Customer", "A customer");
    Container customerApplication = mySoftwareSystem.addContainer("Customer Application",
        "Allows customers to manage their profile.", "Angular");

    Container customerService = mySoftwareSystem.addContainer("Customer Service",
        "The point of access for customer information.", "Java and Spring Boot");
    customerService.addTags(MICROSERVICE_TAG);
    Container customerDatabase = mySoftwareSystem.addContainer("Customer Database",
        "Stores customer information.", "Oracle 12c");
    customerDatabase.addTags(DATASTORE_TAG);

    Container reportingService = mySoftwareSystem.addContainer("Reporting Service",
        "Creates normalised data for reporting purposes.", "Ruby");
    reportingService.addTags(MICROSERVICE_TAG);
    Container reportingDatabase = mySoftwareSystem.addContainer("Reporting Database",
        "Stores a normalised version of all business data for ad hoc reporting purposes.", "MySQL");
    reportingDatabase.addTags(DATASTORE_TAG);

    Container auditService = mySoftwareSystem.addContainer("Audit Service",
        "Provides organisation-wide auditing facilities.", "C# .NET");
    auditService.addTags(MICROSERVICE_TAG);
    Container auditStore = mySoftwareSystem.addContainer("Audit Store",
        "Stores information about events that have happened.", "Event Store");
    auditStore.addTags(DATASTORE_TAG);

    Container messageBus =
        mySoftwareSystem.addContainer("Message Bus", "Transport for business events.", "RabbitMQ");
    messageBus.addTags(MESSAGE_BUS_TAG);

    customer.uses(customerApplication, "Uses");
    customerApplication.uses(customerService, "Updates customer information using", "JSON/HTTPS",
        InteractionStyle.Synchronous);
    customerService.uses(messageBus, "Sends customer update events to", "",
        InteractionStyle.Asynchronous);
    customerService.uses(customerDatabase, "Stores data in", "JDBC", InteractionStyle.Synchronous);
    customerService.uses(customerApplication, "Sends events to", "WebSocket",
        InteractionStyle.Asynchronous);
    messageBus.uses(reportingService, "Sends customer update events to", "",
        InteractionStyle.Asynchronous);
    messageBus.uses(auditService, "Sends customer update events to", "",
        InteractionStyle.Asynchronous);
    reportingService.uses(reportingDatabase, "Stores data in", "", InteractionStyle.Synchronous);
    auditService.uses(auditStore, "Stores events in", "", InteractionStyle.Synchronous);


  }
}
