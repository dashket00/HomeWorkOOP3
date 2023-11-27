class Doctor {
    public void treat() {
        System.out.println("Врач лечит пациента");
    }
}

class Surgeon extends Doctor {
    @Override
    public void treat() {
        System.out.println("Хирург лечит пациента");
    }
}

class Therapist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Терапевт лечит пациента");
    }
}

class Dentist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Дантист лечит пациента");
    }
}

class Patient {
    int treatmentPlan;
    private Doctor doctor;

    public Patient(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void receiveTreatment() {
        doctor.treat();
    }
}

class TherapistWithTreatmentAssignment {
    public void assignDoctor(Patient patient) {
        if (patient != null) {
            if (patient.treatmentPlan == 1) {
                patient.setDoctor(new Surgeon());
            } else if (patient.treatmentPlan == 2) {
                patient.setDoctor(new Dentist());
            } else {
                patient.setDoctor(new Therapist());
            }
        }
    }
}

public class ClinicSimulation {
    public static void main(String[] args) {
        Patient patient = new Patient(1);

        TherapistWithTreatmentAssignment therapist = new TherapistWithTreatmentAssignment();

        therapist.assignDoctor(patient);

        patient.receiveTreatment();
    }
}