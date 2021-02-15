(ns bootcamp.topics.aad-collections
  (:require [clojure.test :refer :all]))

;;
;; Data-structures:
;; ---------------
;;

;
; Vectors:
;

(def some-primes [2 3 5 7 11 13 17 19])

(count some-primes) ;=> 8
(nth some-primes 0) ;=> 2
(nth some-primes 1) ;=> 3
(conj some-primes 23) ;=> [2 3 5 7 11 13 17 19 23]
some-primes ;=> [2 3 5 7 11 13 17 19]

(vector? some-primes) ;=> true
(vector 1 2 3) ;=> [1 2 3]

(instance? java.util.List some-primes) ;=> true
(instance? java.lang.Iterable some-primes) ;=> true

; See http://clojure.org/cheatsheet

; List:

(def some-happy-numbers '(1 7 10 13 19 23 28)) ; https://en.wikipedia.org/wiki/Happy_number

(nth some-happy-numbers 0) ;=> 1
(nth some-happy-numbers 1) ;=> 7

;; by the way, it's pretty rare to take something from a list of values using an index. If you are, it's a code smell
;; (meaning you _might_ be doing something suboptimal, but it might be ok).

(conj some-happy-numbers 0) ;=> (0 1 7 10 13 19 23 28)

(list? some-happy-numbers) ;=> true
(list 1 2 3) ;=> (1 2 3)

(instance? java.util.List some-happy-numbers) ;=> true
(instance? java.lang.Iterable some-happy-numbers) ;=> true

; Pay attention:

(conj [1 2 3] 0) ;=> [1 2 3 0]
(conj '(1 2 3) 0) ;=> (0 1 2 3)

;
; Maps:
;

(def person {:name "<your name here>"
             :email "foo@bar.com"})

person ;=> {:email "foo@bar.com", :name "<your name here>"}

(get person :name) ;=> "<your name here>"
(get person :title) ;=> nil
(get person :title "programmer") ;=> "programmer"

(keys person) ;=> (:email :name)
(vals person) ;=> ("foo@bar.com" "<your name here>")

(assoc person :title "programmer") ;=> {:email "foo@bar.com", :name "<your name here>", :title "programmer"}
person ;=> {:email "foo@bar.com", :name "<your name here>"}

(dissoc person :email) ;=> {:name "<your name here>"}
person ;=> {:email "foo@bar.com", :name "<your name here>"}

; Map is also a function of its keys:

(get person :name) ;=> "<your name here>"
(person :name) ;=> "<your name here>"

; You can test if something is a function:

(ifn? person) ;=> true
(ifn? "foo") ;=> false

; Keywords are functions too

(ifn? :name) ;=> true
(:name person) ;=> "<your name here>"

; Sets:

(def planets #{:mercury, :venus, :earth, :mars, :jupiter, :saturn, :uranus})

(get planets :mars) ;=> :mars
(get planets :pluto) ;=> nil :(

(conj planets :neptune) ;=> #{:mercury :uranus :mars :neptune :jupiter :earth :venus :saturn}
(disj planets :earth) ;=> #{:mercury :uranus :mars :jupiter :venus :saturn}

; Set is also a function for its content

(planets :mars) ;=> :mars
(planets :pluto) ;=> nil

; Excercises: fix these:

(deftest vector-tests
  (is (= 3 (nth [] 2)))
  (is (= [11 22 33] (conj [] 33))))

(deftest list-tests
  (is (= '("a" "b" "c") (conj '() "a"))))

(deftest map-tests
  (is (= "foo" (get {} :name)))
  (is (= {:name "foo" :title "bar"} (assoc {} :title "?")))
  (is (= {:name "foo"} (dissoc {:name "foo" :title "bar"} :?))))

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