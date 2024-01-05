<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/4/2024
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/test" method="post">
        <label for="startPeriod">When do you start your period ?</label>
        <select name="startPeriod" id="startPeriod">
            <option value="1">Before 11 years old</option>
            <option value="2">After 11 years old</option>
        </select>
        <label for="menstrualCycle">Your menstrual cycle length average ?</label>
        <select name="menstrualCycle" id="menstrualCycle">
            <option value="1">Less than 27 years</option>
            <option value="2">More than 27 years</option>
            <option value="0">Not sure</option>
        </select>
        <label for="endometriosis">Do you have a family history  of endometriosis ?</label>
        <select name="endometriosis" id="endometriosis">
            <option value="2">Yes</option>
            <option value="1">No</option>
        </select>
        <label for="giveBirth">Did you give birth ?</label>
        <select name="giveBirth" id="giveBirth">
            <option value="2">Yes</option>
            <option value="1">No</option>
        </select>
        <label for="pregnancyTroubles">Do you have trouble getting pregnant ?</label>
        <select name="pregnancyTroubles" id="pregnancyTroubles">
            <option value="2">Yes</option>
            <option value="1">No</option>
        </select>
        <label for="bmi">Body max index: calculate your BMI</label>
        <input name="weight" id="bmi" type="text" placeholder="Enter your weight in kg">
        <input name="height"  type="text" placeholder="Enter your height in cm">
        <label for="painIntensity">What is your abdominal/pelvic pain intensity</label>
        <select name="painIntensity" id="painIntensity">
            <option value="0">0-2</option>
            <option value="1">3-5</option>
            <option value="1.5">6-8</option>
            <option value="2">9-10</option>
        </select>
        <label for="pelvicPain">When do you experience abdominal or pelvic pain</label>
        <select name="pelvicPain" id="pelvicPain">
            <option value="2">Related to period</option>
            <option value="1">Related to ovulation</option>
            <option value="0">Unrelated to period or ovulation</option>
        </select>
        <label for="intercoursePain">Severity of pain during intercourse ?</label>
        <select name="intercoursePain" id="intercoursePain">
            <option value="0">0-2</option>
            <option value="1">3-5</option>
            <option value="1.5">6-8</option>
            <option value="2">9-10</option>
        </select>
        <label for="painWorse">What makes your pain worse ?</label>
        <select name="painWorse" id="painWorse">
            <option value="1">Bowel movement</option>
            <option value="1">Full bladder</option>
            <option value="1">Urination</option>
            <option value="1">Orgasm</option>
            <option value="0">Not related to anything</option>
        </select>
        <label for="periodDuration">Duration of period ?</label>
        <select name="periodDuration" id="periodDuration">
            <option value="1">1-7 days</option>
            <option value="2">More than 7 days</option>
        </select>
        <label for="periodNature">Nature of periods ?</label>
        <select name="periodNature" id="periodNature">
            <option value="2">Heavy</option>
            <option value="1.5">Moderate</option>
            <option value="1">Light</option>
        </select>
        <label for="cyclePattern">What is your menstrual cycle pattern ?</label>
        <select name="cyclePattern" id="cyclePattern">
            <option value="0">Regular</option>
            <option value="2">Irregular</option>
            <option value="1">Bleeding or spotting between periods</option>
        </select>
        <label for="having">Do you have ?</label>
        <select name="having" id="having">
            <option value="1">Blood in your stool</option>
            <option value="1">Diarrhea</option>
            <option value="1">Constipation</option>
            <option value="1">Abdominal Bloating</option>
        </select>
        <label for="victim">Have you ever been victim of physical abuse or sexual abuse ?</label>
        <select name="victim" id="victim">
            <option value="2">Yes</option>
            <option value="0">No</option>
        </select>
        <input type="submit" value="submit">
    </form>
</body>
</html>
