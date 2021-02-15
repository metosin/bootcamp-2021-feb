(ns bootcamp.topics.aai-map-reduce-filter
  (:require [clojure.test :refer :all]
            [clojure.string :as string]
            [bootcamp.data.books :as b]))

;;
;; Map, reduce and filter:
;;
;; Common functional programming involves:
;;   filter  - When you want to limit the elements from seq
;;   map     - When you want to apply convert each element in some way
;;   reduce  - When you want to reduce a seq to a value
;;

;
; Filter (and remove):
; --------------------
;

(filter odd? [1 2 3 4])                                     ;=> (1 3)
(remove odd? [1 2 3 4])                                     ;=> (2 4)

;
; Map:
; ----
;

; Take a function and apply it to each value in a seq

(inc 41)                                                    ;=> 42
(inc 1336)                                                  ;=> 1337

(map inc [41 1336])                                         ;=> (42 1337)

; map can take more than one seq too

(map + [41 1237] [1 100])                                   ;=> (42 1337)

; The above is:
;   take 41 and 1, apply them to +
;   take 1237 and 100, apply them to +
; In other words:
;   (cons (+ 41 1) (cons (+ 1237 100)))

(subs "foobar" 3)                                           ;=> "bar"

(map subs
     ["foobar" "hello, world" "programming"]
     [3 7 8])                                               ;=> ("bar" "world" "ing")
;
; Reduce:
; -------
;

(reduce + 10 [1 2 3 4])                                      ;=> 20
; (+ 10 1)   => 11
; (+ 11 2)   => 13
; (+ 13 3)   => 16
; (+ 16 4)   => 20

(reduce + [1 2 3 4])                                        ;=> 10
; (+ 1 2)    => 3
; (+ 3 3)    => 6
; (+ 6 4)    => 10

(reduce (fn [acc value]
          (str acc ", " value))
        ["java" "python" "clojure"])                        ;=> "java, python, clojure"


; Exercise:
; ----------

;
; Take a look at the books in bootcamp.data.books namespace.

(type b/books)                                              ;=> clojure.lang.PersistentVector
(vector? b/books)                                           ;=> true
(count b/books)                                             ;=> 6

; Find out how many books are about clojure?

;
; Continue with the books about clojure. This time, produce a seq
; of page counts from all the books that are about clojure:

;
; Continue with the previous example where we got the seq of number of pages.
; Now answer to questions: how many pages we have about clojure in total?


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