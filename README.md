# Description

Cette API permet de gérer des garages et les voitures qui y sont exposées.

# Lancement

Lancer la commande :

    sbt run

# Opérations

## Base de données

Dans la BDD proposée, il y a deux garages :

*  Garage de l'Est (*9bcc1d12-3506-47ee-94f6-3aaadb38fc4d*) qui a une capacité maximale de 1 et qui contient une voiture
*  Garage de l'Ouest (*5c4b8e58-c8d9-40d5-94e8-b3be5e668c6f*) qui a une capacité maximale de 5 et qui contient deux voitures
*  Garage vide (*30db0939-ece9-4c26-bd1a-cdee34033317*) qui a une capacité maximale de 2 et qui ne contient pas de voiture


## Créer un garage

```
curl -X POST \
  http://localhost:9000/garages \
  -H 'content-type: application/json' \
  -d '{"name":"TEST", "address":"TEST", "maximumCapacity": 5}'
```

Le garage généré est renvoyé en JSON.

L'ID du garage y est présent sous la forme d'un UUID.

## Récupérer un garage

```
curl -X GET \
  http://localhost:9000/garages/{id_du_garage}
```

*Exemple test :*

```
curl -X GET \
  http://localhost:9000/garages/9bcc1d12-3506-47ee-94f6-3aaadb38fc4d
```

# Modifier un garage

```
curl -X PUT \
  http://localhost:9000/garages/{id_du_garage} \
  -H 'content-type: application/json' \
  -d '{"name":"NOUVEAU NOM", "address":"NOUVELLE VALEUR", "maximumCapacity": 3}'
```

*Exemple test :*

```
curl -X PUT \
  http://localhost:9000/garages/5c4b8e58-c8d9-40d5-94e8-b3be5e668c6f \
  -H 'content-type: application/json' \
  -d '{"name":"Garage de l'Ouest", "address":"567 avenue de la route 44000 Nantes", "maximumCapacity": 8}'
```

# Supprimer un garage

```
curl -X DELETE \
  http://localhost:9000/garages/{id_du_garage}
```

*Exemple test :*

```
curl -X DELETE \
  http://localhost:9000/garages/30db0939-ece9-4c26-bd1a-cdee34033317
```

# Récupérer les voitures d'un garage

```
curl -X GET \
  http://localhost:9000/garages/{id_du_garage}/cars
```

*Exemple test :*

```
curl -X GET \
  http://localhost:9000/garages/9bcc1d12-3506-47ee-94f6-3aaadb38fc4d/cars
```

# Créer une voiture dans un garage

```
curl -X POST \
  http://localhost:9000/garages/{id_du_garage}/cars\
  -H 'content-type: application/json' \
  -d '{"matriculation":"AA-000-ZZ", "brand": "Ford", "model": "Focus", "color": "Red", "commissioningDate": "2000-01-01", "price": 1024.56}'
```

*Exemple test :*

```
curl -X POST \
  http://localhost:9000/garages/5c4b8e58-c8d9-40d5-94e8-b3be5e668c6f/cars\
  -H 'content-type: application/json' \
  -d '{"matriculation":"AA-000-ZZ", "brand": "Ford", "model": "Focus", "color": "Red", "commissioningDate": "2000-01-01", "price": 1024.56}'
```

**ATTENTION** La commande suivante résultera en une erreur car le garage est déjà plein

```
curl -X POST \
  http://localhost:9000/garages/9bcc1d12-3506-47ee-94f6-3aaadb38fc4d/cars\
  -H 'content-type: application/json' \
  -d '{"matriculation":"AA-000-ZZ", "brand": "Ford", "model": "Focus", "color": "Red", "commissioningDate": "2000-01-01", "price": 1024.56}'
```

# Supprimer toutes les voitures d'un garage

```
curl -X DELETE \
  http://localhost:9000/garages/{id_du_garage}/cars
```

*Exemple test :*

```
curl -X DELETE \
  http://localhost:9000/garages/9bcc1d12-3506-47ee-94f6-3aaadb38fc4d/cars
```

# Récupérer une voiture d'un garage

```
curl -X GET \
  http://localhost:9000/garages/{id_du_garage}/cars/{id_de_la_voiture}
```

*Exemple test :*

```
curl -X GET \
  http://localhost:9000/garages/5c4b8e58-c8d9-40d5-94e8-b3be5e668c6f/cars/184d5510-3e47-4111-a104-a44d2897bda4
```

# Modifier l'immatriculation d'une voiture d'un garage

```
curl -X PUT \
  http://localhost:9000/garages/{id_du_garage}/cars/{id_de_la_voiture} \
  -H 'content-type: text/plain' \
  -d 'RT-092-LM'
```

*Exemple test :*

```
curl -X PUT \
  http://localhost:9000/garages/5c4b8e58-c8d9-40d5-94e8-b3be5e668c6f/cars/184d5510-3e47-4111-a104-a44d2897bda4 \
  -H 'content-type: text/plain' \
  -d 'RT-092-LM'
```

# Supprimer une voiture d'un garage

```
curl -X DELETE \
  http://localhost:9000/garages/{id_du_garage}/cars/{id_de_la_voiture}
```

*Exemple test :*

```
curl -X DELETE \
  http://localhost:9000/garages/5c4b8e58-c8d9-40d5-94e8-b3be5e668c6f/cars/0856d9c4-c81b-41b5-877f-5ef9cdbb34c6
```