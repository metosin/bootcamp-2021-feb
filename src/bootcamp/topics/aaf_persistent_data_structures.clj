(ns bootcamp.topics.aaf-persistent-data-structures
  (:require [clojure.test :refer :all]
            [clojure.string :as string]))

;
; Peristent data-structures:
;

(assoc {:foo "foo"} :bar "bar") ;=> {:foo "foo", :bar "bar"}
(dissoc {:foo "foo" :bar "bar"} :foo) ;=> {:bar "bar"}

(deftest persistent-data-structures-tests
  (let [book {:title "The Joy of Clojure"
              :langs #{:clojure}
              :authors [:fogus]}]

    ; Associate ('add') map with new element
    (is (= {:title "The Joy of Clojure"
            :langs #{:clojure}
            :authors [:fogus]
            :pages 328} ; This is the 'added' key/val
           (assoc book :pages 328)
           ;; assoc-in, update-in can be used for nested stuff (here it doesn't do anything special)
           (assoc-in book [:pages] 328)))

    ; The 'book' is not changed (it's immutable):
    (is (= {:title "The Joy of Clojure"
            :langs #{:clojure}
            :authors [:fogus]}
           book))

    (is (= {:title "THE JOY OF CLOJURE"
            :langs #{:clojure}
            :authors [:fogus]}
           (update book :title string/upper-case)))

    ; Dis-associate by key
    (is (= {:title "The Joy of Clojure"
            :langs #{:clojure}}
           (dissoc book :authors)))))

; Great support for nested collections:
(deftest nested-data-structures
  (let [author {:author {:id :fogus
                         :likes "pizza"}}]
    (is (= {:author {:id :fogus
                     :likes "pizza"
                     :name "Fogus"}}
           (assoc-in author [:author :name] "Fogus")))

    (is (= {:author {:id :fogus
                     :likes "PIZZA"}}
           (update-in author [:author :likes] string/upper-case)))

    ;; No dissoc-in!
    ))

;; EXERCISES
;; Use update-in for both of these

; Your task: add keyword :houser to the authors vector:
(deftest add-author-with-update-in-tests
  (let [book {:title "The Joy of Clojure"
              :langs #{:clojure}
              :authors [:fogus]}]

    (is (= {:title "The Joy of Clojure"
            :langs #{:clojure}
            :authors [:fogus :houser]}
           ;                 ^^^^^^^-------< here

           ))))

; Your task: add 100 points to 'points'.
(deftest add-100-points-to-game-score-tests
  (let [game {:player "John McCarthy"
              :state {:game-started 1429970768115
                      :score {:level 6
                              :points 1237}}}]

    (is (= {:player "John McCarthy"
            :state {:game-started 1429970768115
                    :score {:level 6
                            :points 1337}}}
           ;                        ^^^^---------< here's the +100

           ))))


