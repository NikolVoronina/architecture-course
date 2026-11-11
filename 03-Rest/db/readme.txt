Build the Docker image:
    docker build -t travellers-handbook-db:v1 .

Run a Docker container standalone:
    docker run --name travellers-handbook-db-container -d -p 3306:3306 travellers-handbook-db:v1

Exec into the container to execute a Bash shell:
    docker container exec -it travellers-handbook-db-container bash

Inside the Bash shell, enter these commands to verify the myschema database exists, with expected tables:
    cd /var/lib/mysql/myschema
    ls

Still inside the Bash shell, enter these commands to query the database via the "mysql" command-line tool.
The -p option prompts you for a password, enter enter the password c0nygre
    cd /var/lib/mysql
    mysql -p    
    select * from myschema.destinations;
    select * from myschema.reviews;
    exit

Then enter the following command, to exit the Bash shell:
    exit

Then stop and remove the Docker container:
    docker container rm -f travellers-handbook-db-container