(ns movie-db-exercise.components.search)
(def movie-title (atom "Initial title"))

(defn box []
  [:form {:on-submit #(do
                        (.preventDefault %)
                        ;; TODO: hit OMDb API here
                        )}
   [:h2 "Search for a movie"]
   [:input {:default-value "Enter a movie title"
            :on-change #(reset! movie-title (.-value (.-target %)))}]])
