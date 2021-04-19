# Personal Dictionary

This is a Swing project that is an introduction to basic infrastructure of (native) [Hibernate](https://github.com/barisdalyan/personal-dictionary/blob/master/README.md#hibernate) technology.

## Features

> Create your own dictionary on desktop.

- [x]  You can add new words to your dictionary, update or delete.
- [x]  Find the word you are looking for using dictionary filter.
- [x]  If you are unsure about the correctness of the translations, try searching on Google Translate.
- [x]  Further, you are able to add a new online translate, but you have to modify source code a little bit.

<br>

<img src = "https://github.com/barisdalyan/personal-dictionary/blob/master/img/pd-image.png" alt="Refresh page" width="385" height="465">

## Annotations
- _This project is developed using Java-11 OpenJDK, Swing Api, Hibernate Api and PostgreSQL (on localhost)._
- _Therefore, to be able to use the project you should set up PostgreSQL and paste your DB link to corresponding line in [XML file](https://github.com/barisdalyan/personal-dictionary/blob/master/src/hibernate.cfg.xml)._
- _You need to change **username** and **password** in XML as well, otherwise Hibernate gets angry._
- _See [this](https://github.com/barisdalyan/personal-dictionary/blob/master/DictionaryTable.sql) for simple SQL code._
- _It is important to include contents of initComponents.txt to .java file which is in same directory, otherwise an unexpected error might occur._
- _PostgreSQL JDBC Driver and Hibernate required jars are [here](https://github.com/barisdalyan/personal-dictionary/tree/master/lib)._


Except these annotations, you can modify this infrastructure as you wish.
I would prefer [**Netbeans IDE**](https://netbeans.apache.org/download/index.html).

## Gifs - Windows

- [Search saved word on Google Translate](https://github.com/barisdalyan/personal-dictionary/blob/master/img/search.gif).
- [Update](https://github.com/barisdalyan/personal-dictionary/blob/master/img/update.gif).
- [Deleting](https://github.com/barisdalyan/personal-dictionary/blob/master/img/delete.gif).

# Hibernate
<p align="center">
<img src="https://github.com/barisdalyan/personal-dictionary/blob/master/img/hibernate.png" alt="Refresh page" width="550">
</p>

 Hibernate is a high-performance Object/Relational [persistence](https://github.com/barisdalyan/personal-dictionary/blob/master/README.md#persistence) and query tool,
 which is licensed under the open source GNU Lesser General Public License (LGPL) and of course is free to [download](https://hibernate.org/orm/). 
 Required jars are enough for Java SE. Also, I am going to show Java EE examples coming soon.
 
  Hibernate is an Object-Relational Mapping ([ORM](https://medium.com/@barisdalyane/orm-object-relational-mapping-nedir-3b915911b694)) solution for JAVA.
  It is an open source persistence framework created by Gavin King in 2001. 
  
  Hibernate maps Java classes to database tables and from Java data types to SQL data types.
  
  **Pros (+)**
  
  - Hibernate maps Java classes to databes tables using Xml files or annotations. 
  Difference is annotations are more modern than Xml (used annotations in this project), but Xml is more flexible approach unlike annotations for Entity mapping.
  - Provides simple APIs for storing and retrieving Java objects directly to and from the database (Create-Read-Update-Delete operations).
  - If there is change in the database or in any table, then you need to change the XML file properties only.
  - Manipulates complex associations of objects of your database.
  
  **Cons (-)**
  
  - A lot of effort is required to learn Hibernate.
  - Sometimes debugging and performance tuning becomes difficult.
  - Hibernate does not allow to insert multiple objects (persistent data) to same table using single query. Developer has to write separate query to insert each object.
  - Complex data, mapping from object-to-tables and vise versa reduces performance and increases time of conversion (query conversion).
  
  **Supported Databases**
  
  Following is a list of database engines supported by Hibernate. 
  
  > HSQL Database Engine, MySQL, PostgreSQL, Oracle,  Microsoft SQL Server Database and as many more.
  
  **Supported Technologies**
  > XDoclet Spring, J2EE, Eclipse plug-ins, Maven.
  
## Hibernate Application Architecture

The sections below give a brief description of  each class object involved in Hibernate Application Architecture.

<br>

<p align="center">
<img src="https://github.com/barisdalyan/personal-dictionary/blob/master/img/hibernate-diagram.png" alt="Refresh page" height="400" width="400" >
</p>

### Configuration Object

The Configuration object is usually created only once during application initialization. It represents a configuration or properties file required by the Hibernate. There are two purposes using of configuration object; 

***Database Connection:*** This is handled through one or more configuration files supported by Hibernate. These files are hibernate.properties and hibernate.cfg.xml.
I used XML configuration file in this project.

***Class Mapping Setup:*** This component creates a connection between the Java classes and database tables using XML or Annotations (used in this project).

### SessionFactory Object

Configuration object is used to create a SessionFactory object which configures Hibernate for the application using the supplied configuration file. Also, it allows to instantiate Session object. The SessionFactory is a thread safe object and used by all the threads of an application.

**Not:**  SessionFactory is created once during application and kept its reference to use later. You can create a new SessionFactory object per database using a separate configuration file. So, if you are using multiple databases, then you have to create multiple SessionFactory objects. 

### Session Object

A Session is used to get a connection with a database. The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database.
Persistent objects (entities) are saved and retrieved through a Session object in entity life cycle. The session objects shouldn't be kept open for a long time because they are **not** usually thread safe. ***They should be closed after creating***.

### Query Object

Query objects use SQL or Hibernate Query Language (HQL) string to retrieve data from the database and create objects. We can limit the number of results returned by the query.

### Criteria Object

Criteria objects are used to create and execute object oriented criteria queries to retrieve objects.

### Transaction

A Transaction represents a unit of work with the database and most of the RDBMS supports transaction functionality and Hibernate uses this functionality (rollback) in any mistake. Transactions are handled by an underlying transaction manager (JDBC - JTA).

 
## Persistence

In the software sector persistence refers to make permanent objects, these objects are kept in a persistent storage for reuse. You can use a relational database, file or flash ram as a persistent storage but except for relational databases, rest of storages are not used usually. The operation adding objects to persistent storage is named ***persisting***. So that "we can retrieve these objects whenever we want". This is called ***loading***.



