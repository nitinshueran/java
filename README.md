# Overview document command line tool

The overview document command line tool is a utility which provides functions to alter the state of an existing or new overview document. The follwoing two actions could be performed to an overview document 

```
  Create: Create an empty overview document with the given namespace.
  Load: Load an existing overview document from a given file path and perform overview document operations.
```
 
The following operations can be executed over the new/already-existing overview document:
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
 To get the help on overview document create command, please execute the following command:
 ```
 Command: java -jar overview-document-cmd-{version}.jar --create --help
 ```
 ```
  --create: Create an empty overview document, this option is required when you don't want to load an existing overview document. The following arguments are
            supported by the create action:
           
           1. --name(optional): The overview document name, if not provided, the utility will create overview document with defalt name.
           2. --path(optional): The directory to store the created overview document, if not provided, the utility will create the document in default directory. 
           3. --namespace(mandatory): Namespace for which the empty overview document will be created, this parameter is mandatory. 
```
Sample commands, with various combinations of mandatory and optional arguments, to create an empty overview document:
``` 
 - java -jar overview-document-cmd-{version}.jar --create --namespace=ABC_D
 - java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --namespace=ABC_D
 - java -jar overview-document-cmd-{version}.jar --create --path=../overview-documents/ --namespace=ABC_D
 - java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --path=../overview-documents/ --namespace=ABC_D
``` 


 ### Load an existing overview document
 To get the help on overview document load command, please execute the following command:
 ```
 Command: java -jar overview-document-cmd-{version}.jar --load --help
 ```
 ```
 --load: Load an existing overview document. The following arguments are supported by the load action:
          
         1. --name(optional): The overview document name, if not provided, the utility will lookup for overview document with defalt name.
         2. --path(optional): The directory to load overview document, if not provided, the utility will lookup for the document in default directory. 
 ```  
 Sample commands, with various combinations of mandatory and optional arguments, to load an existing overview document:
 ```
  - java -jar overview-document-cmd-{version}.jar --load
  - java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name
  - java -jar overview-document-cmd-{version}.jar --load --path=../overview-documents/
  - java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name --path=../overview-documents/
 ``` 
 
 ### Overview document operations - List the contents of an overview document
 To get the help on list overview document command, please execute the following command:
 ```
 Command: java -jar overview-document-cmd-{version}.jar --list --help
 ```
 ```
  --list: This operations could be applied to an existing or new overview doucment, to print the content of the overview doument without key material , it will 
          be applied in combination with `--create` or `--load` overview document action. Once the overview doument is created or loaded, this it will print the
          content of the overview document. No arguments are required for this action   
```
Sample commands, with various combinations of mandatory and optional arguments, to create an empty overview document:
``` 
 - java -jar overview-document-cmd-{version}.jar --create --namespace=ABC_D --list
 - java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --namespace=ABC_D --list
 - java -jar overview-document-cmd-{version}.jar --create --path=../overview-documents/ --namespace=ABC_D --list
 - java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --path=../overview-documents/ --namespace=ABC_D --list
 - java -jar overview-document-cmd-{version}.jar --load --list
 - java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name --list
 - java -jar overview-document-cmd-{version}.jar --load --path=../overview-documents/ --list
 - java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name --path=../overview-documents/ --list
```

 ### Overview document operations - Create key for topic
 To get the help on create key command, please execute the following command:
 ```
 Command: java -jar overview-document-cmd-{version}.jar --create-key --help
 ```
 ```
  --create-key: Create a key for a topic with the supplied name, algorithm and expiration. The following arguments are
            supported by the create key operation:
           
           1. --key-name(mandatory): The name with which key will be created.
           2. --topic(mandatory): Topic name for which key will be added, if topic is not present in overview document, it will add the topic to the document.
           3. --algo(mandatory): Algorithm to generate key material.
           4. --expiration(mandatory): Date till which this key will be active.
```
Sample commands, with various combinations of mandatory and optional arguments, to create an empty overview document:
``` 
 - java -jar overview-document-cmd-{version}.jar --create --namespace=ABC_D --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
 - java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --namespace=ABC_D --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
 - java -jar overview-document-cmd-{version}.jar --create --path=../overview-documents/ --namespace=ABC_D --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
 - java -jar overview-document-cmd-{version}.jar --create --name=overview-document-sample-name --path=../overview-documents/ --namespace=ABC_D --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
 
 - java -jar overview-document-cmd-{version}.jar --load --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
 - java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
 - java -jar overview-document-cmd-{version}.jar --load --path=../overview-documents/ --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
 - java -jar overview-document-cmd-{version}.jar --load --name=overview-document-sample-name --path=../overview-documents/ --create-key --key-name=1 --topic=ABC_D_T1 --algo=1 --expiration=20200901
``` 






