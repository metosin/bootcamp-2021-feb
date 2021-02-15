(ns bootcamp.topics.aaa-intro)

(when true "Congratulations, everything seems to work and you're ready for the training!")

;;
;; Personal introductions
;; Expectations
;;






;;
;; What will happen?
;; Course structure
;; Wednesday: Clojure theory, small exercises (~4h)
;; Thursday: "Real-world" Clojure app, library and code walkthrough, implementing new features
;; Friday: ?









;; What is Clojure?
;; Wikipedia: "modern, dynamic, and functional dialect of the Lisp programming language on the Java platform."
;; Also Clojurescript <-> Javascript, Clojure CLR <-> .NET (?)
;; Interop with Java, Javascript
;; macros, REPL, immutability
;; "Anything" you can do with Java or Javascript, you can do with Clojure(script).

;;
;; What does Clojure look like?
;; foobar(1, 2) -> (foobar 1 2) ;; Not so bad, right?
;; 1 + 2 -> (+ 1 2) ;; A bit more difficult
;; 1 < 2 -> (< 1 2) ;; I still can't get used to this after 5 years

;; The above is why Clojure (Lisp) is 'homoiconic'.
;; There aren't really any "reserved words", e.g. return.
;; Code is just a bunch of lists, where the first element is evaluated as a function.
;; This homoiconicity is the reason we can so easily write macros in any Lisp (macro is code that produces code).
;; If this trips you up right now, don't worry about it right now.







;;
;; A word about development tools
;;
;; Available IDEs: Emacs+CIDER, IDEA+Cursive, vs code+Calva..
;; Leiningen, shadow-cljs, (figwheel, deps)
;; REPL
