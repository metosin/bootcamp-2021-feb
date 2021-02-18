(ns bootcamp.topics.aag-functional-programming
  (:require [clojure.test :refer :all]))

;;
;; Functional programming:
;;

; Some definitions:
;
;    ...style of building the structure and elements of computer programs,
;    that treats computation as the evaluation of mathematical functions and
;    avoids state and mutable data.
;
;    source: https://en.wikipedia.org/wiki/Functional_programming
;
; Commonly:
;
; * First-class and higher-order functions
; * Pure functions
;
; Also commonly required:
; * closures
;
; Modern functional concept:
; * persistent data-structures

;
; First-class and higher-order functions:
; ---------------------------------------
;

; First-class function:

(fn [a b] (+ a b))

; Higher-order functions:

; - functions as arguments:
(filter odd? [1 2 3 4 5])

; - functions as return values:
(let [add-2 (partial + 2)]
  (add-2 40))

;
; Purity:
; -------
; Clojure is a 'practical' language, no strict purity enforcement (like in Haskell)
; How ever, clojure has a strong tendency towards purity (persistent datastructures, STM)
;

; Example of a pure function:

(defn hello [message your-name]
  (str message ", " your-name))

; Some non-pure versions:

(defn hello [message your-name]
  (println "generating hello message for" your-name)
  (str message ", " your-name))

(def message (atom nil)) ; known as "evil global mutable state"
; http://programmers.stackexchange.com/questions/148108/why-is-global-state-so-evil

(defn hello [your-name]
  (str (deref message) ", " your-name))

(hello "Teemu")

(reset! message "Greetings")
(hello "world") ;=> "Hello, world"

(reset! message "Moi")
(hello "maailma") ;=> "Moi, maailma"

;; Other ways to "change values" are alter-var-root and dynamic variables (or stuff we will go over in the STM namespace)
;; NEITHER SHOULD BE USED FOR APPLICATION LOGIC
;; You mostly come across them in code that sets up your development environment

(def ^:dynamic some-changing-value 5)

some-changing-value

(comment
  (with-redefs [some-changing-value 10]
    (println "redefined value is" some-changing-value)))

; Why purity matters?
; Pure functions are easy to develop, test and reason about.

; Application with _only_ pure functions does nothing, so some non-pure parts are
; always required. The Right Way(tm) is to be as pure as possible and isolate
; non-pure functions to some non-pure units.

;
; Closures:
; ---------
;

(defn greeter [message] ; <- message here
  (fn [your-name]
    (str message ", " your-name))) ; <- used as closure here

((greeter "Hello") "Teemu")

(let [g (greeter "Hullo")]
  ; now g 'closes over string "Hullo"'
  (str (g "world!")))

(def name-atom (atom nil))
(reset! name-atom "Teemu")
(deref name-atom)
@name-atom
(reset! name-atom nil) ;; assoc
(swap! name-atom clojure.string/upper-case) ;; update
(reset! name-atom (clojure.string/upper-case @name-atom))

;; EXERCISES

;; define an _atom_ called 'counter' that contains the value '4'
(def counter (atom 4))
;; get the value of 'counter' using the '@' operator
@counter
;; update 'counter' to the value '5' with the function 'reset!'
(reset! counter 5)
;; get the value of 'counter' using the function 'deref'
(deref counter)
;; update 'counter' to the value '6' by using the function 'swap!'
;; Hint: remember 'inc'.
(swap! counter (inc 1))