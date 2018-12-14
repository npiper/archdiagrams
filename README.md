# SAPI Architecture Diagrams

## Testing

```
// Get the list of diagrams
http://localhost:8080/sapidiagrams

// Get a diagram (Plantuml PNG)
http://localhost:8080/sapidiagrams/1
```

## Pseudo-code

### Startup

 * Build Model
 * Populate views in view model
 * Run..
 
 
 {22={22 | Demise Dashboard | Repository analysis of demised, deprecated repos}, 23={23 | Stub As a service | Testing support - Mock/Stub backend MQ responses}, 24={24 | Portal Generator | Publish to Anypoint API Manager}, 25={25 | branchingUpdater | Repository analysis - validates branch standards}, 26={26 | Cert Upgrade Tool | Repository analysis - validates branch standards}, 27={27 | GitHub | HSBC Enterprise Github repositories}, 28={28 | Jenkins | HSBC Build Server - Jenkins}, 29={29 | Mulesoft Anypoint | HSBC API Gateway and Catalogue}, 30={30 | Nexus | HSBC Artifact Repository}, 31={31 | JIRA | JIRA}, 10={10 | Pivotal Pacman | }, 32={32 | PCF | Pivotal Cloud Foundry Foundation}, 11={11 | SCA Tool | Static code analysis against coding standards}, 12={12 | RAML Validator | Static code analysis against RAML API standards}, 13={13 | Webhook Wizard | Orchestrates Bronze/Silver checks}, 14={14 | Branching Inspector | Repository analysis - validates branch standards}, 15={15 | Epic Dashboard | Dashboard & API for measuring Bronze, Silver compliance}, 16={16 | Info Investigator | Dashboard for displaying SAPI Information summary}, 17={17 | AuthZ Analyser | Checks AuthZ Policy compliance against registered API's}, 18={18 | SLA Tier Tool | Code generation - activate and configure API Policies}, 19={19 | Standardised Test Generator | Generates JUnit test cases for a Given SAPI}, 1={1 | SAPI Tools | A space for containers of System API's to support integration to backend and fulfilment systems.}, 2={2 | System APIs | HSBC System API's}, 3={3 | SAAS | Security as a service}, 4={4 | DevOps | Devops Tools at HSBC}, 5={5 | SAPI DevOps | SAPI Developer / Test / Ops resource}, 6={6 | SAPI Reviewer | SAPI Developer Lead / Reviewer}, 7={7 | SAPI Ops | SAPI Support Operations}, 8={8 | CF Team | Cross functional team}, 9={9 | SAPI Product Owner | SAPI Product Owner / Scrum Master}, 20={20 | Exchange Uploader | Publish API Documentation to exchange}, 21={21 | API Loader | Orchestrates publishing to Exchange Uploader for API doco}}