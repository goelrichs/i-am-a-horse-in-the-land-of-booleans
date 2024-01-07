(ns i-am-a-horse-in-the-land-of-booleans
  (:refer-clojure :exclude [boolean]))

(defn boolean [x]
  (if x true false))

(defn abs [x]
  (if (< x 0)
    (* x -1)
    x));; => #'i-am-a-horse-in-the-land-of-booleans/abs
(abs 0);; => 0
(abs -2);; => 2
(abs 12);; => 12

(defn divides? [divisor n]
  (= 0 (mod n divisor)));; => #'i-am-a-horse-in-the-land-of-booleans/divides?
(use 'clojure.repl);; => nil
(doc mod);; => nil  NOTE: have to run this in the repl to see more info?
;;-------------------------
;;clojure.core/mod
;;([num pdiv])
;;  Modulus of num and div. Truncates toward negative infinity.
;;nil
;;------------------------
(mod 42 2);; => 0
(mod 100 3);; => 1
(mod 101 3);; => 2
(= 0 (mod 42 2));; => true
(divides? 2 4);; => true
(divides? 4 2);; => false
(divides? 5 10);; => true
(divides? 2 5);; => false

(defn fizzbuzz [n]
  (cond
    (divides? 15 n) "gotcha!"
    (divides? 3 n) "fizz"
    (divides? 5 n) "buzz"
    :else ""));; => #'i-am-a-horse-in-the-land-of-booleans/fizzbuzz
(neg? -11);; => true
(pos? 0);; => false  ...could have sworn zero is positive
(pos? 2);; => true
(defn super-sign [x]
  (cond
    (pos? x) "postive"
    (neg? x) "negative"
    :else "zero"));; => #'i-am-a-horse-in-the-land-of-booleans/super-sign
(super-sign 2);; => "postive"
(super-sign 0);; => "zero"
(super-sign -2);; => "negative"
(fizzbuzz 70);; => "buzz"
(fizzbuzz 2);; => ""
(fizzbuzz 45);; => "gotcha!"
(fizzbuzz 48);; => "fizz"

(defn teen? [age]
  (<= 13 age 19))
(teen? 20);; => false
(teen? 12);; => false
(teen? 13);; => true
(teen? 15);; => true
(teen? 19);; => true
(teen? 27);; => false

;;everything has a value
(defn sign [x]
  (if (>= x 0)
    "+"
    "-"));; => #'i-am-a-horse-in-the-land-of-booleans/sign NOTE: (< x 0) can work too--see abs
(sign 12);; => "+"
(sign 0);; => "+"
(sign -11);; => "-"
;; java would require a return statement, b/c if in java is just a statement NOT SO in clj

(defn not-teen? [age] ;returns true when teen? returns false and false otherwise
  (not (teen? age)));; => #'i-am-a-horse-in-the-land-of-booleans/not-teen?
(not-teen? 20);; => true
(not-teen? 12);; => true
(not-teen? 13);; => false
(not-teen? 15);; => false
(not-teen? 19);; => false
(not-teen? 27);; => true

(defn generic-doublificate [x]
  (cond
    (nil? x) true  ;had to add because (:a 1) evaluates to nil, which is true for empty?
    (number? x) (* 2 x)
    (empty? x) nil
    (list? x) (* 2 (count x))
    (vector? x) (* 2 (count x))
    :else true
    ));; => #'i-am-a-horse-in-the-land-of-booleans/generic-doublificate
(generic-doublificate 5);; => 10
(generic-doublificate [3 5 8 9]);; => 8
(generic-doublificate []);; => nil
(generic-doublificate ());; => nil
(generic-doublificate '(2 4 5));; => 6
(generic-doublificate (:a 1));; => nil
(empty? (:a 1));; => true
(number? (:a 1));; => false
(empty? nil);; => true
(generic-doublificate nil);; => nil
(number? nil);; => false
(nil? nil);; => true
;;added into the cond  (nil? x) true to account for if nil is input into generic-doublificate
(generic-doublificate nil);; => true
(generic-doublificate (:a 1));; => true
;;(generic-doublificate false);; throws an error
(= false nil);; => false
;;(== false nil);; throws an error

(defn leap-year? [year]
  (cond
    (= 0 (mod year 400)) true
    (= 0 (mod year 100)) false
    (= 0 (mod year 4)) true
    :else false
    ));; => #'i-am-a-horse-in-the-land-of-booleans/leap-year?
(leap-year? 40);; => true
(leap-year? 15);; => false
(leap-year? 100);; => false
(leap-year? 200);; => false
(leap-year? 400);; => true
(leap-year? 12);; => true
(leap-year? 20);; => true
; '_______'
