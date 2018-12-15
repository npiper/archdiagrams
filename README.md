# Architecture Diagrams Service

## What this is

Was inspired by using the [C4 architecture models](https://c4model.com/), as a way to bridge the coding / design gap.

What I wanted was an ability to generate some of the lower level diagrams while giving options on different view slices and this to run as a service to serve up the diagrams in different views and formats.

A future goal is for the service calls to dynamically build up views of components by calling out to backend systems (github, Container frameworks) for further information, metadata or to build up component and code level diagrams.

An initial API is defined for the resource `/archdiagrams` (read only)

The service runs as a Spring Boot microservice and renders JSON or PNG results using the frameworks from [PlantUML](http://plantuml.com/api) and [C4 Structurizr](https://github.com/structurizr/java).


### Design approach

The definitions are extensible with the concept of Model / View / Controller.

A tradeoff to be able to allow the link between the Model / View is to define Identifiers for each relevant higher level component such as Containers, Sofware systems or people as identifiers for lookup.

Model - Creates the Workspace and Model  - create all required software systems and relationships between elements.  A recommended practice here is to make good use of 'Tag' or properties attributes on elements and relationships so views can later be 'sliced' on this basis.

View - The model is Autowired to be available to the view components.
The abstract class `AbstractPlantUMLDiagram' contains a lot of the view rendering logic and the abstract methods allow view customisation.

New views should extend this class, be annotated as a spring `@Component` and be put in the package `neilpiper.me.archdiagrams.views`


## Testing


```
// Get the list of diagrams
http://localhost:8080/archdiagrams

// Get a diagram (Plantuml PNG)
http://localhost:8080/archdiagrams/1
```

## Pseudo-code

### Startup

 * Build Model
 * Populate views in view model
 * Run..
 
## Build

[https://travis-ci.org/npiper/archdiagrams](https://travis-ci.org/npiper/archdiagrams)

## Maven Doco

[https://npiper.github.io/archdiagrams](https://npiper.github.io/archdiagrams)
 
# REFERENCES
 
[Include graphics in PlantUML Syntax](http://forum.plantuml.net/3790/please-provide-way-include-data-uri-bitmap-images-diagrams)
 
[C4 Model](https://c4model.com/)

[Java Structurizr](https://github.com/structurizr/java)

[Java Structurizr - Examples](https://github.com/structurizr/java/tree/master/structurizr-examples/src/com/structurizr/example)

[Java Structurizr - PlantUML](https://github.com/structurizr/java/tree/master/structurizr-plantuml)

[Java Generics](https://www.baeldung.com/java-generics)

