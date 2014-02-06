(ns foris-challenge.core
  (:use foris-challenge.nivel1
        foris-challenge.nivel2
        foris-challenge.nivel3))

(defn -main []
  (println "Calculando soluciones...")
  (println "Solucion #1: " (nivel1))
  (println "Solucion #2: " (nivel2))
  (println "Solucion #3: " (nivel3)))

