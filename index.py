# -*- coding: utf-8 -*-

#importing libraries
from sklearn.externals import joblib
import inputScript
import sys
import numpy as np

def main():
    #load the pickle file
    classifier = joblib.load('rf_final.pkl')

    #input url
    url = str(sys.argv[1])
    #print("URL entered by you is : " + sys.argv[1])

    #checking and predicting
    checkprediction = inputScript.main(url)
    prediction = classifier.predict(checkprediction)
    res = int(prediction)
    print (res)
    

    #f = open("D:/NIIT University/3 Year/Semester 6/Capstone Project 1/Project/phishing_randomforest/results.txt","w")
    #f.writelines([a,prediction])
    #f.close()

    #return url

#f = open("D:/NIIT University/3 Year/Semester 6/Capstone Project 1/Project/phishing_randomforest/results.txt","r")
#print("Output from results.txt : ")
#print(f.read())
#f.close()

if __name__ == '__main__':
    main()
