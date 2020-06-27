*********Spring Boot and Postgres*********



**Install Docker**

​	 https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-18-04

**How to run Postgres using docker**

 1. ​	

    *Command* - docker pull postgres

    ```
    Digest: sha256:9ba6355d27ba9cd0acda1e28afaae4a5b7b2301bbbdc91794dcfca95ab08d2ef
    Status: Downloaded newer image for postgres:latest
    docker.io/library/postgres:latest
    ```

2. 

   *Command* - docker images 

   ```
   postgres            latest              b97bae343e06        2 weeks ago         313MB
   ```

3. create persistent data volume for postgres

   *Command* - docker volume create my-vol

   ```
   Digest: sha256:185518070891758909c9f839cf4ca393ee977ac378609f700f60a771a2dfe321
   Status: Downloaded newer image for alpine:latest
   11dd62485c25797166b4420eaa09e2a93fff005797d110fc6fc12e34b68a9574
   ```

4. run postgres

   1. ```
      docker run  --rm --name postgres-docker -e  POSTGRES_PASSWORD=password -p 5432:5432 -v /home/tejas/postgres-data:/var/lib/postgresql/data -d postgres 
      ```

   2. ```
      docker exec -it postgres-docker bash
      root@23bd5d41a93d:/# psql -U postgres
      psql (12.3 (Debian 12.3-1.pgdg100+1))
      Type "help" for help.
      
      postgres=# 
      ```

   3. Create database "room_reservation"

      ```
      postgres=# create database room_reservation;
      CREATE DATABASE
      ```

   4. Exit from psql by \q and bash by exit. 

   5. Setup database "room_reservation"

      ```
      docker exec -i postgres-docker psql room_reservation -U postgres < src/main/resources/schema.sql
      CREATE TABLE
      CREATE TABLE
      CREATE TABLE
      ALTER TABLE
      ALTER TABLE
      ```

      ```
      docker exec -i postgres-docker psql room_reservation -U postgres < src/main/resources/data.sql
      INSERT 0 1
      INSERT 0 1
      INSERT 0 1
      INSERT 0 1
      ```

**How to run springboot app with postgres using docker**

 1. Build springbootapp using Dockerfile -

    *Command* - docker build ./ -t springbootapp

 2. Let's verify both postgres and springbootapp images are available.

    ```
    docker images
    REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
    springbootapp       latest              d081402d9748        51 minutes ago      440MB
    postgres            latest              b97bae343e06        2 weeks ago         313MB
    ```

3. Lets verify postgres container is active

   ```
   docker ps -a
   CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
   23bd5d41a93d        postgres            "docker-entrypoint.s…"   13 minutes ago      Up 12 minutes       0.0.0.0:5432->5432/tcp   postgres-docker
   ```

4. Link both containers and run

   ```
   docker run -t --link postgres-docker:postgres -p 8085:8085 springbootapp 
   
     .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
   ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
     '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    :: Spring Boot ::       (v2.4.0-SNAPSHOT)
    ...
    ...
    ...
    ...
   2020-06-27 11:18:05.419  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8085 (http) with context path ''
   ...
   ...
   2020-06-27 11:18:35.989  INFO 1 --- [           main] DeferredRepositoryInitializationListener : Spring Data repositories initialized!
   2020-06-27 11:18:36.101  INFO 1 --- [           main] c.m.e.l.LearningSpringbootApplication    : Started LearningSpringbootApplication in 117.
   ```

5. Now the Application is running and connected with Postgres server. Let's verify -

   http://localhost:8085/rooms

    ![Screenshot from 2020-06-27 16-59-01](/home/tejas/Pictures/Screenshot from 2020-06-27 16-59-01.png)