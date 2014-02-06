(ns foris-challenge.nivel2)

;; http://challenge.foris.cl/pages/level2
;; Encuentra primer número de Fibonacci que tiene más de 1000 divisores.

(defn divisores
  "Encuentra el conjunto de divisores de un numero N dado. Incluye 1 y N."
  [n]
  (loop [divs #{} x 1]
    (if (> (*' x x) n)
      divs
      (if (zero? (rem n x))
        (recur (into divs [x (/ n x)]) (inc x))
        (recur divs (inc x))))))

(defn nivel2
  "Calcula los numeros de Fibonacci hasta encontrar uno con 1000 divisores."
  []
  (loop [a 1 b 1]
    ;; (println a) ;; debug
    (if (> (count (divisores a)) 1000)
      a
      (recur b (+ a b)))))

;; (println (str "Solucion #2: "(nivel2)))

