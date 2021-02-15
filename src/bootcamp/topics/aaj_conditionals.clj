(ns bootcamp.topics.aaj-conditionals)

;; If(-else)

(if (= 1 1)
  "if-branch"
  "else-branch")

;; There's no if-elseif-else in Clojure!

;; This works
(if (= 1 1)
  "Do something")

;; But you should prefer 'when' for single cases
(when (= 1 1)
  "Do something")

;; One practical reason for this is side-effects

(when (= 1 1)
  (side-effect-one)
  (side-effect-two))

(if (= 1 1)
  (side-effect-one)
  (side-effect-two))

(if (= 1 1)
  (do
    (side-effect-one)
    (side-effect-two)))

;; Cond
(def a 1)
(cond
  (< a 2) "A is less than two"
  (> a 2) "A is more than two"
  :default "A equals two")

;; The "default" case in cond is a predicate that is always truthy!

(cond
  (< a 2) "A is less than two"
  (> a 2) "A is more than two"
  true "A equals two")

;; But commonly we use :else or :default

;; Case

(case a
  1 "A is less than two"
  2 "A equals two"
  "A is more than two")

;; The "default" case in 'case' is a result without a test-expression
;; It's pretty easy to mix these up, but try to remember that 'cond' uses predicates,
;; 'case' uses values -> since there's no "magic word" for the default case, cond _needs_
;; a predicate that is always true.

;; EXERCISES

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