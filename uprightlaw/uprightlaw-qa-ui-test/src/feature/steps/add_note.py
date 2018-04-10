from behave import *


@given('I create a case on crm')
def create_case(self):
    print('I create a case on crm')
    print('\n')


@when('I open the broswer')
def open_broswer(self):
    print('I open the broswer')
    print('\n')


@when('I enter to crm address http://crm-test.uprightlaw.com')
def enter_address(self):
    print('I enter to crm address http://crm-test.uprightlaw.com')
    print('\n')


@when('I login with admin account')
def login(self):
    print('I login with admin account')
    print('\n')


@when('I find the case')
def find_case(self):
    print('I find the case')
    print('\n')


@when('I add a note')
def add_note(self):
    print('I add a note')
    print('\n')


@when('I find note in note&activity')
def find_note(self):
    print('I find note in note&activity')
    print('\n')


@then('I close broswer and delete data')
def close_broswer(self):
    print('I close broswer and delete data')
    print('\n')
