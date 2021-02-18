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

(filter odd? [1 2 3 4]) ;=> (1 3)
(remove odd? [1 2 3 4]) ;=> (2 4)

;
; Map:
; ----
;

; Take a function and apply it to each value in a seq

(inc 41) ;=> 42
(inc 1336) ;=> 1337

(map inc [41 1336]) ;=> (42 1337)

; map can take more than one seq too

(map + [41 1237] [1 100]) ;=> (42 1337)

; The above is:
;   take 41 and 1, apply them to +
;   take 1237 and 100, apply them to +
; In other words:
;   (cons (+ 41 1) (cons (+ 1237 100)))

(subs "foobar" 3) ;=> "bar"

(map subs
     ["foobar" "hello, world" "programming"]
     [3 7 8]) ;=> ("bar" "world" "ing")
;
; Reduce:
; -------
;

(reduce
  (fn [a b] (+ a b))
  10
  [1 2 3 4]) ;=> 20
; (+ 10 1)   => 11
; (+ 11 2)   => 13
; (+ 13 3)   => 16
; (+ 16 4)   => 20

(reduce + [1 2 3 4]) ;=> 10
; (+ 1 2)    => 3
; (+ 3 3)    => 6
; (+ 6 4)    => 10

(reduce (fn [acc value]
          (str acc ", " value))
        ["java" "python" "clojure"]) ;=> "java, python, clojure"


; Exercise:
; ----------

;; increment all the numbers in the vector '[4 7 9 10]' by one. Use the 'map' function.
;; Hint: the function 'inc'

(map inc [4 7 9 10])

;; do the same as in the previous exercise, but leave only the even results in the vector.
;; Use the functions 'filter' and 'even?'

(filter even? (map inc [4 7 9 10]))

;
; Take a look at the books in bootcamp.data.books namespace.

(type b/books) ;=> clojure.lang.PersistentVector
(vector? b/books) ;=> true
(count b/books) ;=> 6
b/books

; Find out how many books are about clojure?

(#{:mars :earth} :earth) ;; truthy
(#{:mars :earth} :pluto) ;; falsey

(filter
  (fn [book]
    ((:langs book) :clojure))
  b/books)

(filter
  (comp :clojure :langs)
  b/books)

;
; Continue with the books about clojure. This time, produce a seq
; of page counts from all the books that are about clojure:
(map :pages
     (filter
       (comp :clojure :langs)
       b/books))
;
; Continue with the previous example where we got the seq of number of pages.
; Now answer to questions: how many pages we have about clojure in total?

(reduce +
        (map :pages
             (filter
               (comp :clojure :langs)
               b/books)))

;; https://clojuredocs.org/clojure.core/for
;; use the 'for' structure to go through this vector of maps,
;; and return a sequence of the ':value's: '(7.0 3.0 1)':
[{:id 1 :value 7.0} {:id 2 :value 3.0} {:id 7 :value 1}]

(for [single-map [{:id 1 :value 7.0}
                  {:id 2 :value 3.0}
                  {:id 7 :value 1}]]
  (:value single-map))

(doall
  (for [single-element [{:id 1 :values [7.0 6]}
                        {:id 2 :values [3.0 609 17 9001]}
                        {:id 7 :values [1]}]
        :when (> (:id single-element) 1)
        single-value (:values single-element)
        :let [value-squared (* 2 single-value)]]
    [(:id single-element)
     single-value
     value-squared]))

;; challenge! use the 'reduce' function to combine a vector of maps like this:
(comment
  (combine [{:a 1 :b 2} {:c 3} {:d 4 :e 5}]))
;;       ==> {:a 1 :b 2 :c 3 :d 4 :e 5}

(defn combine [collection-of-maps]
  ;; These are the same
  (reduce merge collection-of-maps)
  (reduce
    (fn [accumulator value]
      (merge accumulator value))
    collection-of-maps))
