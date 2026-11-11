Open a Command Prompt window and go to the following folder:
    C:\DockerKubernetesDev\Student\14-Assignment\api-dotnet\DestinationsWebApi
     
In this folder, run the following command to build the image manually (so you have control over the image name):
    docker build -t travellers-handbook-api:v1 -f DestinationsWebApi\Dockerfile .