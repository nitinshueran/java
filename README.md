# Overview document command line tool

The overview document command line tool is a utility which provides functions to alter the state of an existing or new overview document. The follwoing two actions could be performed to an overview document 

```
  Create: Create and empty overview document with the given namespace.
   Load: Load and existing overview document from a given file path and perform overview document operations.
```
 
The following operations can be executed over the new/already existing overview document:
```
  List: List the content of the overview document.
  Create Key: Create a new key associated with the given topic name.
  Remove Key: Removes the given key name from the associate topic.
  Renew Keys: Renew all keys which will expire before the supplied date.
  Unmark: Unmark a topic from End to end encryption.  
```
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

```
Java development kit 1.8 and above.
Maven - 3.x.x and above.
```

### Checkout, Build and Run

A step by step guide that tell you how to get a development env running

```
 1. Clone the repository from github from: 
 2. Move to local direcoty containing the clone, move to overview-document-cmd directory by executing: cd overview-document-cmd/
 3. Build the project using mvn clean package, this will build and project and create an executable in target directory with the name overview-document-cmd-{version}.jar
 4. Load the overview document command line tool help page by executing: java -jar overview-document-cmd-{version}.jar --help command.
 5. You can now run the above mentioned actions using the help page guidelines.
```

## Command line tool --help menu

The command line tool help menu will display all actions and their arguments that needs to be supplied, please use the following command to display help page for the tool
```
java -jar overview-document-cmd-{version}.jar --help
```

 
 ### Create an empty overview document
 
 ```
 To create an empty overview document, please supply the following parameters:
 Command1: java -jar overview-document-cmd-{version}.jar --create --namespace=ABC_D
 Command2: java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --namespace=ABC_D
 Command3: java -jar overview-document-cmd-{version}.jar --create --path=../overview-documents/ --namespace=ABC_D
 Command4: java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --path=../overview-documents/ --namespace=ABC_D
 
 To get the help on overview document create command, please execute the following command:
 Command: java -jar overview-document-cmd-{version}.jar --create --help
 
 The above command will display all the options which you can supply via the create command:
 
 --create: Create and empty overview document, this option is required when you don't want to load an existing overview document. The following parameters are
           supported by the create action:
           
           1. --name(optional): The overview document name, if not provided, the utility will create overview document with defalt name.
           2. --path(optional): The directory to store the created overview document, if not provided, the utility will create the document in default directory. 
           3. --namespace(mandatory): Namespace for which the empty overview document will be created, this parameter is mandatory. 
 
 ```

 ### Load an existing overview document
 
```
To load an existing overview document, please supply the following parameters:
 Command1: java -jar overview-document-cmd-{version}.jar --load
 Command2: java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name
 Command3: java -jar overview-document-cmd-{version}.jar --load --path=../overview-documents/
 Command4: java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name --path=../overview-documents/
 
 To get the help on overview document load command, please execute the following command:
 Command: java -jar overview-document-cmd-{version}.jar --load --help
 
 The above command will display all the options which you can supply via the load command:
 
 --load: Load an existing overview document. The following parameters are supported by the load action:
          
           1. --name(optional): The overview document name, if not provided, the utility will lookup for overview document with defalt name.
           2. --path(optional): The directory to load overview document, if not provided, the utility will lookup for the document in default directory. 
  
```




