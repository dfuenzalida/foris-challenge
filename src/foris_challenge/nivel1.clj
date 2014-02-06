(ns foris-challenge.nivel1)

;; http://challenge.foris.cl/pages/level1

(defn palin?
  "Retorna verdadero si una palabra es palindromo"
  [s]
  (and (not= "" s) (= s (apply str (reverse s)))))

(defn find-palins [texto]
  (for [x (range (count texto))
        y (range 2 70) ;; Deberia ser: (range 2 (- (count texto) x))
        :let [s (apply str (take y (drop x texto)))]
        :when (palin? s)]
    s))

(defn nivel1
  "Encuentra el palindromo más largo en el archivo 'string.txt'"
  []
  (let [texto (slurp "string.txt")
        palins (find-palins texto)]
    (reduce
     #(if (> (count %1) (count %2)) %1 %2)
     palins)))

;; (println (str "Solucion #1: '" (nivel1) "'"))

