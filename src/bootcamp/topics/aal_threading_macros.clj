(ns bootcamp.topics.aal-threading-macros)

;; Clojure is sometimes written "inside out"
(nth (filter even? (map inc (take 100 (range)))) 15)

;; To help with this Clojure has nice "threading macros":
;; -> inserts x as the first item
;; ->> inserts x as the last item
;; And the more rare:
;; as-> binds x to a name (and places it where you wish)
;; some->, some->> like ->,->> but eliminates when result is nil
;; cond->, cond->> applies the expression whenever the test predicate is true

;; -> inserts x as the first item
(let [data {:FIRSTNAME :teemu
            :LASTNAME :kaukoranta}]
  (-> data
      ;; Turn keywords into strings
      (update :FIRSTNAME name)
      (update :LASTNAME name)
      ;; Whoops! This is tricky
      ;; :FIRSTNAME and :LASTNAME in 'data' are still keywords
      (assoc :name (str (name (:FIRSTNAME data)) " " (name (:LASTNAME data))))
      (dissoc :FIRSTNAME :LASTNAME)))

;; ->> inserts x as the last item
(->> (range)
     (take 100)
     (map inc)
     (filter even?))

;; Dang
(nth (->> (range)
          (take 100)
          (map inc)
          (filter even?))
     15)

;; It can be hard to mix functions that take the coll/seq as the last or first argument
;; From a previous topic:
; When working with seq, keep in mind, am I working with a collection, or a seq:
;
; core functions that work with data-structures:
;   (func <data-structure> args)
;
; core functions that work with seq's:
;   (func args <seq>)
;; In practise, this "mixing" is rare, and when it happens, you should ask yourself if you're
;; maybe doing something a bit strange. It's likely ok, and then you'll just work around it.
;; Or use as->

(as-> (range) €
      (take 100 €)
      (map inc €)
      (filter even? €)
      (nth € 15))

;; some->, some->> can be nice for easy nil-checking

(defn get-age-from-db! [person-id]
  (get {:id7 18} person-id))

(-> (get-age-from-db! :id7)
    inc
    (+ 30))

(comment
  (-> (get-age-from-db! :id8)
      inc
      (+ 30)))

(some-> (get-age-from-db! :id8)
        inc
        (+ 30))

;; Clojure is _quite_ good at handling nil values, so you shouldn't have to worry about them other than
;; with arithmetic operations.

;; Finally cond->, cond->>
;; Which I'm not sure I've ever used myself..?

;; https://clojuredocs.org/clojure.core/cond-%3E%3E
;; useful for when you want to control doing a bunch of things to a lazy sequence
;; based on some conditions or, commonly, keyword arguments to a function.
(defn do-stuff
  [coll {:keys [map-fn max-num-things batch-size]}]
  (cond->> coll
           map-fn         (map map-fn)
           max-num-things (take max-num-things)
           batch-size     (partition batch-size)))

(do-stuff [1 2 3 4] {})
(do-stuff [1 2 3 4] {:map-fn str})
(do-stuff [1 2 3 4] {:map-fn str :batch-size 2})
(do-stuff [1 2 3 4] {:map-fn str :max-num-things 3})

;; https://clojuredocs.org/clojure.core/cond-%3E
; Consider a code snippet that coerces any string to an integer, else noop:
(let [x "123"]
  (if (string? x)
    (Integer. x)
    x))

; We can reduce the repetition of `x` by using `cond->`
(let [x "123"]
  (cond-> x
          (string? x) (Integer.)))

;; Fizzbuzz

(defn divisible-by? [divisor number]
  (zero? (mod number divisor)))

(defn say [n]
  (cond-> nil
          (divisible-by? 3 n) (str "Fizz")
          (divisible-by? 5 n) (str "Buzz")
          :always             (or (str n))))

(say 1)
(say 3)
(say 5)
(say 15)