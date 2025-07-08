# Fawry Quantum Book Store 



## Design
* I thought that first to have an abstract class for book to carry the common book attributes & functionality 
* By Making a Common Book class we could then add new books easily
* In The book interface there is a **GetBook()** Method, each book method implements it differently 
  bec ebook needs to get book by email but paper book need shipment
* Some Book Types aggregates inside it the IDelivery Strategy so we could decide which method we will send the book with.
  for example Ebook initially takes an Email Service Strategy ,  this design helps us introduce new strategies easily
  also if the book strategy changed our classes could adapt easily



## Assumptions

* Demo Book Doesn't have a price
* EBook Doesn't have quantity
* I decide book is outdated if its year is less than the year provided by user


## Class Diagram

![Class Diagram](./class_diagram_quantum_books.jpg)