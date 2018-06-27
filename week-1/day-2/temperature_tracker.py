import unittest


class TempTracker(object):

    # Implement methods to track the max, min, mean, and mode
    temp=[]
    total=0
    mode =0
    min=0
    max=0
    count=0
    dict1={}
    def insert(self, temperature):
        self.count=self.count+1
        self.total=self.total+temperature
        if(len(self.dict1)==0):
            self.min = temperature
            self.max = temperature
            self.mode = temperature
            self.dict1[temperature]=1
        elif(temperature in self.dict1.keys()):
            if(self.min>temperature):
                self.min=temperature
            if(self.max<temperature):
                self.max=temperature
            self.dict1[temperature]=self.dict1[temperature]+1
            if(self.dict1[temperature]>self.dict1[self.mode]):
                self.mode = temperature
        else:
            if(self.min>temperature):
                self.min=temperature
            if(self.max<temperature):
                self.max=temperature
            self.dict1[temperature]=1
            
    def get_max(self):
        return self.max

    def get_min(self):
        return self.min

    def get_mean(self):
        return self.total/self.count

    def get_mode(self):
        return self.mode
           
           
# Tests

class Test(unittest.TestCase):

    def test_tracker_usage(self):
        tracker = TempTracker()

        tracker.insert(50)
        msg = 'failed on first temp recorded'
        self.assertEqual(tracker.get_max(), 50, msg='max ' + msg)
        self.assertEqual(tracker.get_min(), 50, msg='min ' + msg)
        self.assertEqual(tracker.get_mean(), 50.0, msg='mean ' + msg)
        self.assertEqual(tracker.get_mode(), 50, msg='mode ' + msg)

        tracker.insert(80)
        msg = 'failed on higher temp recorded'
        self.assertEqual(tracker.get_max(), 80, msg='max ' + msg)
        self.assertEqual(tracker.get_min(), 50, msg='min ' + msg)
        self.assertEqual(tracker.get_mean(), 65.0, msg='mean ' + msg)
        self.assertIn(tracker.get_mode(), [50, 80], msg='mode ' + msg)

        tracker.insert(80)
        msg = 'failed on third temp recorded'
        self.assertEqual(tracker.get_max(), 80, msg='max ' + msg)
        self.assertEqual(tracker.get_min(), 50, msg='min ' + msg)
        self.assertEqual(tracker.get_mean(), 70.0, msg='mean ' + msg)
        self.assertEqual(tracker.get_mode(), 80, msg='mode ' + msg)

        tracker.insert(30)
        msg = 'failed on lower temp recorded'
        self.assertEqual(tracker.get_max(), 80, msg='max ' + msg)
        self.assertEqual(tracker.get_min(), 30, msg='min ' + msg)
        self.assertEqual(tracker.get_mean(), 60.0, msg='mean ' + msg)
        self.assertEqual(tracker.get_mode(), 80, msg='mode ' + msg)


unittest.main(verbosity=2)