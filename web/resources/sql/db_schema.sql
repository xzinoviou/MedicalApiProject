#CREATE & USE MEDICINE_DB
DROP DATABASE MEDICINE_DB;
CREATE DATABASE MEDICINE_DB;
USE MEDICINE_DB;

#1. MEDICINE
CREATE TABLE MEDICINE(
MEDICINE_ID BIGINT NOT NULL AUTO_INCREMENT,
MEDICINE_KEY VARCHAR(100) NOT NULL UNIQUE,
NAME TEXT,
DESCRIPTION TEXT,
PRICE DOUBLE,
VALID BOOLEAN,
PRODUCER TEXT,
PRIMARY KEY(MEDICINE_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;
#VALUES
INSERT INTO MEDICINE(MEDICINE_KEY,NAME,DESCRIPTION,PRICE,VALID,PRODUCER) VALUES
('EMEA000520','Advate','Advate is indicated for treatment and prophylaxis of bleeding in patients with haemophilia A (congenital factor-VIII deficiency.',59.85 ,true,'Baxter AG'),
('EMEA000219','Ammonaps','Ammonaps is indicated as adjunctive therapy in the chronic management of urea cycle disorders, involving deficiencies of carbamylphosphate synthetase, ornithine transcarbamylase orargininosuccinate synthetase.',121.31,true,'Swedish Orphan Biovitrum International AB'),
('EMEA000081','Betaferon','Betaferon is indicated for the treatment of patients with a single demyelinating event with an active inflammatory process.',32.25,true,'Bayer AG'),
('EMEA000725','Binocrit','Binocrit is indicated for treatment of symptomatic anaemia associated with chronic renal failure (CRF) in adult and paediatric patients.',45.99,true,'Sandoz GmbH'),
('EMEA001241','Brilique','Brilique is co-administered with acetylsalicylic acid (ASA), and it is indicated for the prevention of atherothrombotic events in adult patients with acute coronary syndromes (ACS) or a history of myocardial infarction (MI) and a high risk of developing an atherothrombotic event',199.23,true,'AstraZeneca AB'),
('EMEA000089','Caelyx','Caelyx is indicated as monotherapy for patients with metastatic breast cancer, where there is an increased cardiac risk and for treatment of advanced ovarian cancer in women who have failed a first-line platinum-based chemotherapy regimen in combination with bortezomib for the treatment of progressive multiple myeloma in patients who have received at least one prior therapy and who have already undergone or are unsuitable for bone marrow transplant.',234.90,true,'Janssen-Cilag International N.V.'),
('EMEA000982','Celvapan','Celvapan is indicated for prophylaxis of influenza caused by A(H1N1)v 2009 virus and it should be used in accordance with official guidance.',23.45,false,'Nanotherapeutics Bohumil'),
('EMEA000334','Ceprotin','Ceprotin is indicated in purpura fulminans and coumarin-induced skin necrosis in patients with severe congenital protein C deficiency.',67.23,true,'Baxter AG'),
('EMEA000222','CoAprovel','CoAprovel is indicated for treatment of essential hypertension. This fixed dose combination is indicated in adult patients whose blood pressure is not adequately controlled on irbesartan or hydrochlorothiazide alone.',12.56,true,'Sanofi Clir SNC'),
('EMEA002087','Dificlir','Dificlir is indicated in adults for the treatment of Clostridium difficile infections (CDI) also known as C. difficile-associated diarrhoea (CDAD).',22.45,true,'Astellas Pharma Europe BV'),
('EMEA000476','Dukoral','Dukoral is indicated for active immunisation against disease caused by Vibrio cholerae serogroup O1 in adults and children from 2 years of age who will be visiting endemic/epidemic areas.',89.14,true,'Valneva Sweden AB'),
('EMEA003717','Ebilfumin','Ebilfumin is indicated for the prevention of influenzaPost-exposure in individuals 1 year of age or older following contact with a clinically diagnosed influenza case when influenza virus is circulating in the community.',34.21,true,'Actavis Group PTC'),
('EMEA002148','Eliquis','Eliquis is indicated for the prevention of venous thromboembolic events (VTE) in adult patients who have undergone elective hip or knee replacement surgery.',52.01,true,'Bristol-Myers Squibb'),
('EMEA000533','Emtriva','Emtriva is indicated for the treatment of HIV-1 infected adults and children in combination with other antiretroviral agents. This indication is based on studies in treatment-naive patients and treatment-experienced patients with stable virological control.',48.23,true,'Gilead Sciences Ireland UC'),
('EMEA000169','Exelon','Exelon is indicated for Symptomatic treatment of mild to moderately severe Alzheimers dementia. Also for symptomatic treatment of mild to moderately severe dementia in patients with idiopathic Parkinsons disease.',230.23,true,'Novartis Europharm Ltd'),
('EMEA000236','Ferriprox','Ferriprox is indicated for the treatment of iron overload in patients with thalassaemia major when current chelation therapy is contraindicated or inadequate.',223.10,true,'Apotex Europe BV'),
('EMEA000899','Firazyr','Firazyr is indicated for symptomatic treatment of acute attacks of hereditary angioedema (HAE) in adults (with C1-esterase-inhibitor deficiency).',45.10,true,'Shire Orphan Therapies GmbH'),
('EMEA000619','Fosavance','Fosavance is indicated for treatment of postmenopausal osteoporosis in patients at risk of vitamin-D insufficiency and it reduces the risk of vertebral and hip fractures.',34.29,true,'Merck Sharp & Dohme B.V.'),
('EMEA003833','Glyxambi','Glyxambi is indicated in adults aged 18 years and older to improve glycaemic control when metformin and/or sulphonylurea (SU) and one of the monocomponents of Glyxambi do not provide adequate glycaemic control.',98.10,true,'Boehringer Ingelheim International GmbH'),
('EMEA004406','Hemlibra','Hemlibra is indicated for routine prophylaxis of bleeding episodes in patients with haemophilia A with factor VIII inhibitors.',52.10,true,'Roche Registration Limited'),
('EMEA000610','Noxafil','Nplate is indicated for adult chronic-immune (idiopathic)-thrombocytopenic-purpura (ITP) patients who are refractory to other treatments (e.g. corticosteroids, immunoglobulins).',21.19,true,'Merck Sharp & Dohme Ltd'),
('EMEA000818','Nevanac','Nevanac is indicated for prevention and treatment of postoperative pain and inflammation associated with cataract surgery, reduction in the risk of postoperative macular oedema associated with cataract surgery in diabetic patients.',32.89,true,'Novartis Europharm Limited'),
('EMEA000626','Neupro','Parkinson''s disease:Neupro is indicated for the treatment of the signs and symptoms of early-stage idiopathic Parkinson''s disease as monotherapy (i.e. without levodopa) or in combination with levodopa, i.e. over the course of the disease, through to late stages when the effect of levodopa wears off or becomes inconsistent and fluctuations of the therapeutic effect occur (end of dose or ''on-off'' fluctuations).Restless-legs syndrome:Neupro is indicated for the symptomatic treatment of moderate to severe idiopathic restless-legs syndrome in adults.',5.89,true,'UCB Pharma S.A.'),
('EMEA003860','Nucala','Nucala is indicated as an add-on treatment for severe refractory eosinophilic asthma in adult patients.',59.99,true,'GlaxoSmithKline Trading Services'),
('EMEA002778','Inflectra','Rheumatoid arthritis, Inflectra, in combination with methotrexate, is indicated for the reduction of signs and symptoms as well as the improvement in physical function in: adult patients with active disease when the response to diseasemodifying antirheumatic drugs (DMARDs), including methotrexate, has been inadequate',16.79,false,'Pfizer Europe MA EEIG'),
('EMEA000210','Pritor','Hypertension Treatment of essential hypertension in adults. Cardiovascular prevention Reduction of cardiovascular morbidity in patients with: manifest atherothrombotic cardiovascular disease (history of coronary heart disease, stroke, or peripheral arterial disease) or type-2 diabetes mellitus with documented target-organ damage.',20.49,true,'Bayer AG'),
('EMEA001012','Resolor','Resolor is indicated for symptomatic treatment of chronic constipation in adults in whom laxatives fail to provide adequate relief.',132.99,true,'Shire Pharmaceuticals Ireland Ltd'),
('EMEA001026','Victoza','Victoza is indicated for the treatment of adults with insufficiently controlled type 2 diabetes mellitus as an adjunct to diet and exercise as monotherapy when metformin is considered inappropriate due to intolerance or contraindications in addition to other medicinal products for the treatment of diabetes.For study results with respect to combinations, effects on glycaemic control and cardiovascular events, and the populations studied.',45.49,false,'Novo Nordisk A/S');


#2. EFFECT
CREATE TABLE EFFECT(
EFFECT_ID BIGINT NOT NULL AUTO_INCREMENT,
DESCRIPTION TEXT,
PRIMARY KEY(EFFECT_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;
#VALUES


#3. PRODUCER
CREATE TABLE PRODUCER(
PRODUCER_ID BIGINT NOT NULL AUTO_INCREMENT,
NAME TEXT,
DESCRIPTION TEXT,
TEL TEXT,
EMAIL TEXT,
FAX TEXT,
ADDRESS TEXT,
PRIMARY KEY(PRODUCER_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;

#4. SIDE EFFECT
CREATE TABLE SIDE_EFFECT(
SIDE_EFFECT_ID BIGINT NOT NULL AUTO_INCREMENT,
DESCRIPTION TEXT,
PRIMARY KEY(SIDE_EFFECT_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;
#VALUES
INSERT INTO SIDE_EFFECT(DESCRIPTION) VALUES
('flushing of the face'),('headache'),('nausea'),('fast heartbeat'),('burning'),('redness'),('irritation'),('fever'),('chills'),
('anaemia'),('thrombocytopenia'),('leukopenia'),('leukocytosis'),('thrombocytosis'),
('itching'),('swelling'),('shortness of breath'),
('pyrexia'),('hypertension'),('arthralgia'),('muscle spasm'), ('dizziness'),('upper respiratory tract infection'),
('strokes'), ('bleeding into the brain'), ('fainting'),
('dry mouth'),('internal bleeding'),('gastrointestinal upsets'),('uterine contractions'),('abortion'),('birth defects'),
('depression'),('diarrhea'),('erectile dysfunction'),('hair loss'),('hypertention'),('liver damage'),('suicide'),('insomnia'),
('death'),('deafness'),('addiction');

SELECT * FROM SIDE_EFFECT;



#5. ACTIVE_SUBSTANCE
CREATE TABLE ACTIVE_SUBSTANCE(
ACTIVE_SUBSTANCE_ID BIGINT NOT NULL AUTO_INCREMENT,
ATC_KEY VARCHAR(100) NOT NULL UNIQUE,
ACTIVE_SUBSTANCE_NAME TEXT,
DESCRIPTION TEXT,
PRIMARY KEY(ACTIVE_SUBSTANCE_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;
#VALUES
INSERT INTO ACTIVE_SUBSTANCE(ATC_KEY,ACTIVE_SUBSTANCE_NAME,DESCRIPTION) VALUES
('B02BD02','octocog alfa','Antihemophilic Factor, Human Recombinant is the recombinant form of human antihemophilic factor (AH)) (Factor VIII) with coagulation promoting activity. Antihemophilic factor binds to factor IXa in the coagulation cascade along with calcium and phospholipid.'),
('A16AX03','sodium phenylbutyrate','Sodium Phenylbutyrate is the sodium salt of phenylbutyrate, a derivative of the short-chain fatty acid butyrate, with potential antineoplastic activity'),
('L03AB08','interferon beta-1b','Interferon beta binds to type I interferon receptors (IFNAR1 and IFNAR2c) which activate two Jak (Janus kinase) tyrosine kinases (Jak1 and Tyk2). These transphosphorylate themselves and phosphorylate the receptors.'),
('B03XA01','epoetin alfa','Binding of erythropoietin to the erythropoietin receptor leads to receptor dimerization, which facilitates activation of JAK-STAT signaling pathways within the cytosol.'),
('B01AC24','ticagrelor','icagrelor is a P2Y12 Platelet Inhibitor. The mechanism of action of ticagrelor is as a Phenylalanine Hydroxylase Activator, and P2Y12 Receptor Antagonist, and Cytochrome P450 3A4 Inhibitor, and Cytochrome P450 3A5 Inhibitor, and P-Glycoprotein Inhibitor. The physiologic effect of ticagrelor is by means of Decreased Platelet Aggregation.'),
('L01DB','doxorubicin hydrochloride','Doxorubicin Hydrochloride is the hydrochloride salt of doxorubicin, an anthracycline antibiotic with antineoplastic activity. Doxorubicin, isolated from the bacterium Streptomyces peucetius var. caesius, is the hydroxylated congener of daunorubicin.'),
('J07BB01','influenza vaccine H1N1 whole virion, inactivated, prepared in cell culture','The Comparative Toxicogenomics Database (CTD) promotes understanding about the effects of environmental chemicals.'),
('B01AD12','human protein C','Protein C.'),
('C09DA04','irbesartan / hydrochlorothiazide','Hydrochlorothiazide mixture with Irbesartan; 448264-66-2; Karvezide; CoAprovel; Irbesartan-hydrochlorothiazide; Irbesartan Hydrochlorothiazide BMS.'),
('A07AA12','fidaxomicin','Fidaxomicin is a narrow-spectrum, 18-membered macrolide antibiotic isolated from the actinomycete Dactylosporangium aurantiacum subsp. hamdenensis with potential antibacterial activity. '),
('J07AE01','recombinant cholera toxin B subunit / vibrio cholerae 01','The cholera toxin B subunit ameliorates experimentally induced colitis in mice. In humans, cholera toxin B subunit has never been tested in the treatment of Crohns disease CD.'),
('J05AH02','oseltamivir','Oseltamivir is an acetamido cyclohexene that is a structural homolog of SIALIC ACID and inhibits NEURAMINIDASE.'),
('B01AF02','apixaban','Apixaban is an orally active inhibitor of coagulation factor Xa with anticoagulant activity. Apixaban directly inhibits factor Xa, thereby interfering with the conversion of prothrombin to thrombin and preventing formation of cross-linked fibrin clots.'),
('J05AF09','emtricitabine','Emtricitabine is a synthetic fluoro derivative of thiacytidine with potent antiviral activity. Emtricitabine is phosphorylated to form emtricitabine 5-triphosphate within the cell. This metabolite inhibits the activity of human immunodeficiency virus (HIV) reverse transcriptase both by competing with the natural substrate deoxycytidine 5-triphosphate and by incorporation into viral DNA causing a termination of DNA chain elongation (due to the lack of the essential 3-OH group).'),
('N06DA03','rivastigmine','Rivastigmine is a carbamate-derived reversible CHOLINESTERASE INHIBITOR that is selective for the CENTRAL NERVOUS SYSTEM and is used for the treatment of DEMENTIA in ALZHEIMER DISEASE and PARKINSON DISEASE.'),
('V03AC02','deferiprone','Deferiprone is an orally bioavailable bidentate ligand with iron chelating activity. Deferiprone binds to iron in a 3:1 (ligand:iron) molar ratio. By binding to iron, deferiprone is able to remove excess iron from the body.'),
('B06AC02','icatibant','Icatibant (Firazyr) is a synthetic peptidomimetic drug consisting of ten amino acids, and acts as an effective and specific antagonist of bradykinin B2 receptors. It has been approved in the EU for use in hereditary angioedema, and is under investigation for a number of other conditions in which bradykinin is thought to play a significant role. Icatibant currently has orphan drug status in the United States and FDA approved on August 25, 2011.'),
('M05BB03','alendronic acid / colecalciferol','Alendronic Acid/Colecalciferol is indicated for the treatment of postmenopausal osteoporosis in women at risk of vitamin D insufficiency. Alendronic Acid/Colecalciferol reduces the risk of vertebral and hip fractures.'),
('A10BD19','empagliflozin / linagliptin','Empagliflozin is a sodium glucose co-transporter-2 (SGLT-2) inhibitor indicated as an adjunct to diet and exercise to improve glycemic control in adult patients with type 2 diabetes. SGLT2 co-transporters are responsible for reabsorption of glucose from the glomerular filtrate in the kidney. The glucuretic effect resulting from SGLT2 inhibition reduces renal absorption and lowers the renal threshold for glucose, therefore resulting in increased glucose excretion. Additionally, it contributes to reduced hyperglycaemia and also assists weight loss and blood pressure reduction.'),
('B02BX','emicizumab','Hemlibra is indicated for routine prophylaxis of bleeding episodes in patients with haemophilia A with factor VIII inhibitors.'),
('J02AC04','posaconazole','Posaconazole is a broad-spectrum, second generation, triazole compound with antifungal activity. Posaconazole strongly inhibits 14-alpha demethylase, a cytochrome P450-dependent enzyme. Inhibition of 14-alpha-demethylase prevents the conversion of lanosterol to ergosterol, an important component of the fungal cell wall. Inhibition of ergosterol synthesis changes the fungal cell membrane composition and integrity, alters membrane permeability and eventually leads to fungal cell lysis.'),
('S01BC10','nepafenac','Nepafenac is a Nonsteroidal Anti-inflammatory Drug. The mechanism of action of nepafenac is as a Cyclooxygenase Inhibitor. The chemical classification of nepafenac is Nonsteroidal Anti-inflammatory Compounds.'),
('N04BC09','rotigotine','Rotigotine is a non-ergot dopamine receptor agonist used in the therapy of Parkinson disease and restless leg syndrome. Administered as a once daily transdermal patch, rotigotine has not been associated with serum enzyme elevations during treatment or with episodes of clinically apparent liver injury.'),
('R03DX09','mepolizumab','Nucala is indicated as an add-on treatment for severe refractory eosinophilic asthma in adults, adolescents and children aged 6 years and older'),
('L04AB02','infliximab','Flixabi, in combination with methotrexate, is indicated for the reduction of signs and symptoms as well as the improvement in physical function'),
('C09CA07','telmisartan','Telmisartan is a benzimidazole derivative and a non-peptide angiotensin II receptor antagonist with antihypertensive property. Telmisartan selectively antagonizes angiotensin II binding to the AT1 subtype receptor, located in vascular smooth muscle and adrenal gland. The antagonism results in vasodilation and inhibits the angiotensin II-mediated aldosterone production, which in turn leading to a decrease in sodium and water as well as an increase in potassium excretion leading to a subsequent reduction in blood pressure.'),
('A06AX05','prucalopride succinate','Prucalopride is contraindicated where there is hypersensitivity to the active substance or to any of the excipients, renal impairment requiring dialysis, intestinal perforation or obstruction due to structural or functional disorder of the gut wall, obstructive ileus, severe inflammatory conditions of the intestinal tract, such as Crohns disease, and ulcerative colitis and toxic megacolon/megarectum.'),
('A10BJ02','liraglutide','Liraglutide is a long-acting, fatty acylated glucagon-like peptide-1 (GLP-1) analog administered subcutaneously, with antihyperglycemic activity. Liraglutides prolonged action and half-life of 11-15 hours are attributed to the attachment of the fatty acid palmitic acid to GLP-1 that reversibly binds to albumin. Albumin binding protects liraglutide from immediate degradation and elimination and causes GLP-1 to be released from abumin in a slow and consistent manner. This agent may cause thyroid C-cell tumors and increases the risk of acute pancreatitis.');


#6.USER
CREATE TABLE USER(
USER_ID BIGINT NOT NULL AUTO_INCREMENT,
USER_EMAIL VARCHAR(100) NOT NULL UNIQUE,
USER_PASSWORD VARCHAR(100) NOT NULL,
FIRST_NAME TEXT,
LAST_NAME TEXT,
DATE_OF_BIRTH DATE,
TEL TEXT,
ADDRESS TEXT,
PRIMARY KEY(USER_ID))ENGINE = INNODB DEFAULT CHARSET = UTF8;
INSERT INTO USER (USER_EMAIL,USER_PASSWORD,FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,TEL,ADDRESS) VALUES
('xenofon@email.com','Xenofon1!','Xenofon','Zinoviou','2018-1-20','6900900900','Ermou 25, Athens'),
('alexandros@email.com','Alexandros1!','Alexandros','Dikonimos','2018-12-31','6988888888','Stadiou 18, Athens'),
('doctor1@email.com','Doctor1!','Michael','Donaghue','1950-8-12','6940123456','Voulis 4, Athens'),
('doctor2@email.com','Doctor2!','Paul','Castle','1970-4-15','6997675511','Ormou 24, Peristeri'),
('visitor1!@email.com','Visitor1!','Ahsley','Thomas','1995-10-11','6912441212','Leof. Vouliagmenis 156, Argyroupoli'),
('visitor2!@email.com','Visitor2!','Yuri','Keller','2000-1-1','2000100099','28A Visiting Castle, England');



#7.ROLE
CREATE TABLE ROLE(
ROLE_ID BIGINT NOT NULL AUTO_INCREMENT,
ROLE_TYPE TEXT NOT NULL,
PRIMARY KEY(ROLE_ID))ENGINE = INNODB DEFAULT CHARSET = UTF8;

INSERT INTO ROLE (ROLE_TYPE) VALUES ('ADMIN'),('DOCTOR'),('VISITOR');



#8USER_ROLE
CREATE TABLE USER_ROLE(
USER_ID BIGINT NOT NULL,
ROLE_ID BIGINT NOT NULL,
PRIMARY KEY(USER_ID,ROLE_ID),
FOREIGN KEY(USER_ID)REFERENCES USER(USER_ID),
FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ROLE_ID))ENGINE = INNODB DEFAULT CHARSET = UTF8;
INSERT INTO USER_ROLE VALUES(1,1),(2,1),(3,2),(4,2),(5,3),(6,3);

#9. MEDICINE_ACTIVE_SUBSTANCE
CREATE TABLE MEDICINE_ACTIVE_SUBSTANCE(
MEDICINE_ID BIGINT NOT NULL,
ACTIVE_SUBSTANCE_ID BIGINT NOT NULL,
PRIMARY KEY(MEDICINE_ID,ACTIVE_SUBSTANCE_ID),
FOREIGN KEY(MEDICINE_ID)REFERENCES MEDICINE(MEDICINE_ID),
FOREIGN KEY(ACTIVE_SUBSTANCE_ID)REFERENCES ACTIVE_SUBSTANCE(ACTIVE_SUBSTANCE_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;
#VALUES
INSERT INTO MEDICINE_ACTIVE_SUBSTANCE(MEDICINE_ID,ACTIVE_SUBSTANCE_ID) VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10),
(11,11),
(12,12),
(13,13),
(14,14),
(15,15),
(16,16),
(17,17),
(18,18),
(19,19),
(20,20),
(21,21),
(22,22),
(23,23),
(24,24),
(25,25),
(26,26),
(27,27),
(28,28);


#10. MEDICINE_PRODUCER
CREATE TABLE MEDICINE_PRODUCER(
MEDICINE_ID BIGINT NOT NULL,
PRODUCER_ID BIGINT NOT NULL,
PRIMARY KEY(MEDICINE_ID,PRODUCER_ID),
FOREIGN KEY(MEDICINE_ID)REFERENCES MEDICINE(MEDICINE_ID),
FOREIGN KEY(PRODUCER_ID)REFERENCES PRODUCER(PRODUCER_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;

#11. MEDICINE_EFFECT
CREATE TABLE MEDICINE_EFFECT(
MEDICINE_ID BIGINT NOT NULL,
EFFECT_ID BIGINT NOT NULL,
PRIMARY KEY(MEDICINE_ID,EFFECT_ID),
FOREIGN KEY(MEDICINE_ID)REFERENCES MEDICINE(MEDICINE_ID),
FOREIGN KEY(EFFECT_ID)REFERENCES EFFECT(EFFECT_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;


#13. MEDICINE_SIDE_EFFECT
CREATE TABLE MEDICINE_SIDE_EFFECT(
MEDICINE_ID BIGINT NOT NULL,
SIDE_EFFECT_ID BIGINT NOT NULL,
PRIMARY KEY(MEDICINE_ID,SIDE_EFFECT_ID),
FOREIGN KEY(MEDICINE_ID)REFERENCES MEDICINE(MEDICINE_ID),
FOREIGN KEY(SIDE_EFFECT_ID)REFERENCES SIDE_EFFECT(SIDE_EFFECT_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;
INSERT INTO MEDICINE_SIDE_EFFECT(MEDICINE_ID,SIDE_EFFECT_ID) VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,5),
(3,3),
(4,4),
(5,5),
(6,40),
(6,22),
(6,25),
(7,8),
(7,9),
(8,15),
(9,42),
(10,11),
(10,23),
(10,40),
(11,43),
(11,2),
(12,12),
(13,12),
(13,39),
(13,21),
(14,30),
(15,37),
(15,2),
(15,4),
(16,10),
(16,12),
(16,17),
(17,1),
(17,38),
(18,21),
(19,3),
(19,4),
(19,9),
(20,22),
(20,11),
(20,14),
(21,15),
(21,5),
(21,9),
(22,40),
(22,42),
(23,5),
(24,10),
(24,11),
(24,25),
(25,29),
(25,33),
(26,10),
(26,15),
(27,39),
(27,31),
(27,11),
(28,4),
(28,9),
(28,38);


#14.PRESCRIPTION
CREATE TABLE PRESCRIPTION(
PRESCRIPTION_ID BIGINT NOT NULL AUTO_INCREMENT,
DOCTOR_ID BIGINT NOT NULL,
PATIENT_ID BIGINT NOT NULL,
DATE_OF_ISSUE DATE,
DESCRIPTION TEXT,
PRIMARY KEY(PRESCRIPTION_ID),
FOREIGN KEY(DOCTOR_ID) REFERENCES USER(USER_ID),
FOREIGN KEY(PATIENT_ID) REFERENCES USER(USER_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;

#15. MEDICINE_PRESCRIPTION
CREATE TABLE MEDICINE_PRESCRIPTION(
MEDICINE_ID BIGINT NOT NULL,
PRESCRIPTION_ID BIGINT NOT NULL,
QUANTITY INT,
PRIMARY KEY(MEDICINE_ID,PRESCRIPTION_ID),
FOREIGN KEY(MEDICINE_ID) REFERENCES MEDICINE(MEDICINE_ID),
FOREIGN KEY(PRESCRIPTION_ID) REFERENCES PRESCRIPTION(PRESCRIPTION_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;

#16.DR SPECIALIZATION
CREATE TABLE MD_SPECIALIZATION(
SPECIALIZATION_ID BIGINT NOT NULL AUTO_INCREMENT,
TITLE TEXT,
PRIMARY KEY(SPECIALIZATION_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;

#17 SPECIALIZATION
CREATE TABLE DOCTOR_MD_SPECIALIZATION(
DOCTOR_ID BIGINT NOT NULL,
SPECIALIZATION_ID BIGINT NOT NULL,
PRIMARY KEY(DOCTOR_ID,SPECIALIZATION_ID),
FOREIGN KEY(DOCTOR_ID)REFERENCES USER(USER_ID),
FOREIGN KEY(SPECIALIZATION_ID)REFERENCES MD_SPECIALIZATION(SPECIALIZATION_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;