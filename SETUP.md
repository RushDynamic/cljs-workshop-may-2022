# Instructions for project and workspace setup

1. Create new app using Leiningen using the `reagent-frontend` template, and include shadow-cljs for hot-reloading.
```
lein new app reagent-frontend +shadow-cljs
```
2. Run `npm install` to install all the required js deps.
3. Start the app using 
```
npx shadow-cljs watch app
```
4. In Calva, select *Connect to a running REPL*, select nREPL server, provide the port number available after step 3.
5. In Calva REPL, run `(cljs)` to start the CLJS REPL.
