(ns foris-challenge.nivel3)

;; http://challenge.foris.cl/pages/level3

(def FILENAME "triangle.txt")

(defn read-numbers
  "Convierte un archivo de texto con numeros en una lista de numeros"
  [filename]
  (map
   #(Integer. %)
   (.split (.replaceAll (slurp filename) "\n" " ") " +")))

(defn as-vectors [numbers]
  "Particiona una lista de numeros en vectores de tamaño ascendente"
  (loop [vects [] n 1 numbers numbers]
    (if (seq numbers)
      (recur (conj vects (into [] (take n numbers))) (inc n) (drop n numbers))
      vects)))

(defn compute-max
  "Dadas 2 filas de numeros computa la suma entre 2 filas para el algoritmo"
  [a b]
  (let [a (into a [0])]
    (vec
     (for [i (range (count a))]
       (if (zero? i)
         (+ (a 0) (b 0))
         (+ (b i)
            (max (a (dec i)) (a i))))))))

(defn loop-max
  "Itera a traves de las filas calculando las sumas, luego encuentra el maximo"
  [rows]
  (loop [top (first rows)
         rows (rest rows)]
    (if (seq rows)
      (recur (compute-max top (first rows)) (rest rows))
      (reduce max top))))

(defn nivel3 []
 (loop-max
  (as-vectors (read-numbers FILENAME))))
