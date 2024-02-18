# Courier Quest 

## Description

The Courier Quests MySQL is designed to manage courier quests and achievements within a courier delivery system. It allows couriers to track their current quest progress and view their achievements.

## API Endpoints

The API defines the following endpoints:

- **POST /couriers**  
  Creates a new courier with a unique ID.

- **GET /couriers**  
  Retrieves a list of all registered couriers.

- **POST /couriers/{courierId}/achievements**  
  Adds or updates achievements for the specified courier.

- **GET /couriers/{courierId}/achievements**  
  Retrieves all achievements associated with the specified courier.

- **POST /couriers/{courierId}/current-quest**  
  Updates or adds the current quest progress for the specified courier.

- **GET /couriers/{courierId}/current-quest**  
  Retrieves the current quest progress for the specified courier.

## Examples

- To add a new courier with ID `courier1`, use the following command:

    ```bash
    curl -X POST http://localhost:8081/couriers \
    -H "Content-Type: application/json" \
    -d '{"id": "courier1"}'
    ```

- To retrieve all registered couriers, use the following command:

    ```bash
    curl -X GET http://localhost:8081/couriers
    ```

- To add or update achievements for a courier with ID `courier1`, use the following command:

    ```bash
    curl -X POST http://localhost:8081/couriers/courier1/achievements \
    -H "Content-Type: application/json" \
    -d '{
      "totalDeliveries": 10,
      "totalEarnings": 10.00,
      "currentTier": "Silver",
      "ordersLeftForNextTier": 2
    }'
    ```

- To retrieve achievements for a courier with ID `courier1`, use the following command:

    ```bash
    curl -X GET http://localhost:8081/couriers/courier1/achievements
    ```

- To update or add current quest progress for a courier with ID `courier1`, use the following command:

    ```bash
    curl -X POST http://localhost:8081/couriers/courier1/current-quest \
    -H "Content-Type: application/json" \
    -d '{
      "ordersCompleted": 20,
      "ordersNeededForNextTier": 20,
      "rewardForCurrentTier": 500.00,
      "currentTier": "Diamond",
      "nextTier": "Bronze",
      "timeLeftToCompleteTier": "2 days"
    }'
    ```

- To retrieve current quest progress for a courier with ID `courier1`, use the following command:

    ```bash
    curl -X GET http://localhost:8081/couriers/courier1/current-quest
    ```
**Note:** `courier1` is used as an example and already exists. Please use a different ID (e.g., `courier3`) to create a new courier.