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

(defn side-effect-one [] (println "Executing one!"))
(defn side-effect-two [] (println "Executing two!"))

(comment
  (when (= 1 1)
    (side-effect-one)
    (side-effect-two)))

(comment
  (if (= 1 1)
    (side-effect-one)
    (side-effect-two) ;; Not ran!
    ))

(comment
  (if (= 1 1)
    ;; Do helps
    (do
      (side-effect-one)
      (side-effect-two))))

(and 1 nil 8)

(let [money nil]
  (* 2 (or money 0)))

;; Cond
(def a 3)
(cond
  (< a 2) "A is less than two"
  (> a 2) "A is more than two"
  :default "A equals two")

;; The "default" case in cond is a predicate that is always truthy!
;; In Clojure, only nil and false are 'false'. Everything else is truthy

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

;; Case needs a matching clause or it throws an IllegalArgumentException
;; Cond returns nil if there's no match

;; The "default" case in 'case' is a result without a test-expression
;; It's pretty easy to mix these up, but try to remember that 'cond' uses predicates,
;; 'case' uses values -> since there's no "magic word" for the default case, cond _needs_
;; a predicate that is always true.

;; EXERCISES

;; use the 'let' structure to define a local variable 'b' with the value '"bork"'.
;; Then use the 'str' function to combine two 'b's into '"borkbork"'.

(let [b "bork"]
  (str b b))

;; define a function 'small?' that returns 'true' for numbers under 100

(defn small? [n]
  (if (< n 100)
    true
    false))

(small? 99)
(small? 100)

;; define a function 'message!' using (nested) if structures.
;;    (message! :boink) ==> "Boink!"
;;    (message! :pig)   ==> "oink"
;;    (message! :ping)  ==> "pong"

(defn message! [k]
  (if (= k :boink)
    "Boink!"
    (if (= k :pig)
      "oink"
      (if (= k :ping)
        "pong"
        "unknown"))))

(message! :boink)
(message! :pig)
(message! :ping)
(message! :wat)

;; reimplement 'message!' using the 'cond' structure

(defn message! [k]
  (cond
    (= :boink k)
    "Boink!"

    (= :pig k)
    "oink"

    (= :ping k)
    "pong"

    :else
    "unknown"))

;; reimplement 'message!' using the 'case' structure

(defn message! [k]
  (case k
    :boing "Boink!"
    :pig "oink"
    :ping "pong"
    "unknown"))

;; challenge! use the 'loop' structure to add '1' to an empty vector until it has 10 elements.
;;   Note: 'loop' can be hard. Don't get stuck on this exercise!

;; 5!
(defn factorial [n]
  (if (= n 1)
    1

    (* n (factorial (- n 1)))))

(defn factorial [n]
  (loop [result 1
         factorial-integer n]
    (if (= factorial-integer 1)
      result

      (recur (* result factorial-integer)
             (dec factorial-integer)))))

(factorial 1)