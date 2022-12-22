# Store Management System

The task is to build a Store management system. To manage the store, we need to work
with three parts: users, products and stores.

---
## Users
The users in the store management system has the name, ID (generated automatically in
a sequence from 1000). The system works with two kinds of users:
1. Employee has a salary. In addition, we can update the salary and increase it with a
specific percentage as a bonus.

2. Customer holds how many times he/she visits (buys from) the store. A customer is
called a new customer if he/she visits the store one or two times. In the other cases,
he/she is called a special customer.

---
## Products

Each product has a name, price, ID (generated automatically). There is a special kind of
product called Special-Products. These special products have a relation between each
other, e.g. the same offer, can buy together … etc. Each Special-Products has the name of
this relationship and has a list of these Special-Products. Make sure, in the final, you can
get the same list of Special-Products by using any special product in this list.

---
## Store

Each store has a name and a list of products in that store. Assume that it has 100 products
as a maximum size. The store can do different functionalities:
1. isExist: to decide whether a specific product is available/exist in the store or not.

2. addProduct: to decide whether can add a specific product in the store or not. It
must add that product if it is possible.
 
3. removeProduct: to decide whether can remove a specific product in the store or
not. It must remove that product if it is already in the store.

4. totalPrice: calculates the total price of a specific list of products chosen by the user
(part of the main products in the store). Make sure, you will give a discount 25%
only for a special customer.

5. buy: to manipulate a complete buy operation for a specific user and a specific list
of products(part of the main products in the store). Make sure he/she can buy
only an exist product, remove it from store, then print the final information
included the total price
