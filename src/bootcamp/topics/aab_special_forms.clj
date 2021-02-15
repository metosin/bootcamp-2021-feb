;; In clojure, code is organised into namespaces
(ns bootcamp.topics.002-special-forms
  (:require [clojure.test :refer :all]))

; Define something to this namespace

(def answer 42)

; Evaluate it:
answer ;=> 42

; The 'answer' is now bound to value 42 in this namespace

; We'll examine stuff using tests, like this:
(deftest answer-tests
  (is (= 42 answer)))

;;
;; Local bindings:
;;

(let [a 21
      b 2]
  (str "a * b =" (* a b)))

(deftest let-tests
  (let [a 21
        b 2]
    (is (= 21 a))
    (is (= 2 b))
    (let [b 1337]
      (is (= 1337 b)))
    (is (= 2 b))))

;; defn defines a function
(defn two-parameters [a b]
  (+ a b))

;; defn takes a docstring
(defn my-docstringed "This function is quite useless" []
  "Common error is to put the dosctring AFTER the parameters. This is already a part of the function body,
  and won't do anything"
  (two-parameters 1 1))

;; Metadata
(def ^{:docstring "Foobar"} foobar 100)

;;
;; Use 'do' to evaluate multiple statements (always for side-effects)
;;

(defn result []
  (println "result:"
           (if (= (* 2 21) answer)
             (do
               (println "Yes, we have the answer")
               "yes")
             (do
               (println "Not, for some reason we do not have the answer")
               "no"))))


;;
;; if
;;

(deftest if-tests
  (is (= "Yes" (if true "Yes")))
  (is (= "No" (if false "Yes" "No")))
  (is (= nil (if false "Yes"))))

;; EXERCISES

; Examine what is considered as 'true', change the "?" to "Yes" or "No":

(deftest truthy-tests
  (is (= "?" (if true "Yes" "No")))
  (is (= "?" (if answer "Yes" "No")))
  (is (= "?" (if "hello" "Yes" "No")))
  (is (= "?" (if false "Yes" "No")))
  (is (= "?" (if nil "Yes" "No"))))

;
; Fix this test:
;

(deftest fix-these-let-tests
  (let [a "hello"
        b "world"]
    (is (= "Hello, world" (str a b)))))

;; calculate '4+3'

;; calculate '(2+8/3)*9'

;; call the function 'get' with arguments '"bootcamp"' and '1'

;; use 'defn' to define a function greetings that works like this: '(greetings) ==> "hello!"'

;; define a function 'double' that works like this: '(double 5) ==> 10', '(double 1) ==> 2'

;; add a _docstring_ to the function 'double'. Then show it using '(doc double)'.

;; challenge! implement a 'factorial' function using recursion.
;; eg. 5! = 5 x 4 x 3 x 2 x 1 = 120
