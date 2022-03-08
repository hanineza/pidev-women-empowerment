**Test Postman** 

**Formation**
**@PostMapping("/save")**
créer formation

formateur peut virer, sactionner ou Avertir l'apprenant 
![img_6.png](img_6.png)

**@PutMapping("/uploadFile/{id}")**
uploadFile & affectation à formation
![img_1.png](img_1.png)
![img_2.png](img_2.png)

**Evaluation**
l'apprenant evalue (rating)la formation
**@PutMapping("/save/{user_id}/{formation_id}/{rating}")**
![img.png](img.png)

**Certificat**
l'admin gére les certificat :
export file dont les corrdonner de l'apprenant afin qu'il puisse lui préparer son Certif
**@GetMapping("/pdf/generate/{id}/{idf}")**
![img_3.png](img_3.png)
créer certificat
**@PostMapping("/save")**

l'admin envoie un email notifiant l'apprenent que son certif est prête .
**@GetMapping("/sendmail/{id}")**
![img_4.png](img_4.png)
![img_5.png](img_5.png)


un Qr code sera géner ; l'apprenant peut consulter son certif en ligne en scannant le Qr Code 

@GetMapping("/pdf/generate/{id}/{idf}")
