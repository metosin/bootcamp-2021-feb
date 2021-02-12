(ns bootcamp.exercises)

;; SYNTAX

;; calculate '4+3'

;; calculate '(2+8/3)*9'

;; call the function 'get' with arguments '"bootcamp"' and '1'

;; define a vector with the elements '10', '"hi"', 'true' and ':barbar'

;; define a _map_ with the key '1' is associated with the value '"hello"' and the key ':key'
;;   with the value '[13 7]'

;; use 'def' to define a _variable_ 'my-map' that refers to the map '{1 2}'.
;;   Use the 'assoc' function to add a new key and value to 'my-map'. What does
;;   the 'assoc' call return?  What is the value of 'my-map' after the call?

;; use 'conj' to add a value to a vector

;; use the function 'get' to get the second element from a vector

;; use the function 'get' to get the value of a key from a map

;; get the value of a key from a map using the map itself as a function

;; get the value of a key from a map using a keyword as a function

;; use the function 'get-in' to return the value ':treasure' from the value:
{:description "cave"
 :crossroads [{:contents :monster}
              nil
              {:contents [:trinket :treasure]}]}

;; use 'defn' to define a function greetings that works like this: '(greetings) ==> "hello!"'

;; define a function 'double' that works like this: '(double 5) ==> 10', '(double 1) ==> 2'

;; add a _docstring_ to the function 'double'. Then show it using '(doc double)'.

;; challenge! implement a 'factorial' function using recursion.
;; eg. 5! = 5 x 4 x 3 x 2 x 1 = 120

;; CONDITIONALS & STRUCTURES
;; use the 'let' structure to define a local variable 'b' with the value '"bork"'.
;; Then use the 'str' function to combine two 'b's into '"borkbork"'.

;; define a function 'small?' that returns 'true' for numbers under 100

;; define a function 'message!' using (nested) if structures.
;;    (message! :boink) ==> "Boink!"
;;    (message! :pig)   ==> "oink"
;;    (message! :ping)  ==> "pong"

;; reimplement 'message!' using the 'cond' structure

;; reimplement 'message!' using the 'case' structure

;; challenge! use the 'loop' structure to add '1' to an empty vector until it has 10 elements.
;;   Note: 'loop' can be hard. Don't get stuck on this exercise!

;; FUNCTIONAL PROGRAMMING (?)
;; increment all the numbers in the vector '[4 7 9 10]' by one. Use the 'map' function.
;; Hint: the function 'inc'

;; do the same as in the previous exercise, but leave only the even results in the vector.
;; Use the functions 'filter' and 'even?'

;; use the 'for' structure to go through this vector of maps,
;; and return a sequence of the ':value's: '(7.0 3.0 1)':
[{:id 1 :value 7.0} {:id 2 :value 3.0} {:id 7 :value 1}]

;; Use the function 'update-in' to change 3 into 4 in the value below:
{:shops [:shop-1]
 :customers [{:id "Pekka"
              :account {:balance 3}}]}

;; challenge! use the 'reduce' function to combine a vector of maps like this:
;;    (combine [{:a 1 :b 2} {:c 3} {:d 4 :e 5}])
;;       ==> {:a 1 :b 2 :c 3 :d 4 :e 5}

;; ATOMS

;; define an _atom_ called 'counter' that contains the value '4'

;; get the value of 'counter' using the '@' operator

;; update 'counter' to the value '5' with the function 'reset!'

;; get the value of 'counter' using the function 'deref'

;; update 'counter' to the value '6' by using the function 'swap!'
;; Hint: remember 'inc'.